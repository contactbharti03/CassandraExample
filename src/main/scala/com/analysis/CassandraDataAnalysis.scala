package com.analysis

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.annotation.Experimental
import org.apache.spark.sql.SQLContext
import com.datastax.spark.connector.toDataFrameFunctions
import org.apache.log4j.Logger

object CassandraDataAnalysis {
  def main(args: Array[String]): Unit = {
    val logger = Logger.getLogger(this.getClass())
    val sparkconf = new SparkConf()
      .set("spark.cassandra.connection.host", "localhost")
      .setAppName("test")
      .setMaster("local[*]")
    val sc = new SparkContext(sparkconf)
    val sqlContext = new SQLContext(sc)

    logger.info("creating dataframe from cassandra")

    val primary = sqlContext
      .read
      .format("org.apache.spark.sql.cassandra")
      .options(Map("table" -> "primaryresult", "keyspace" -> "test"))
      .load()

    logger.info("Grouping data and applying aggregation")

    val votes_groupBy_party = primary.groupBy("party").sum("votes").select("party", "sum(votes)")
    votes_groupBy_party.show()

    logger.info("saving dataframe to cassandra")

    votes_groupBy_party.createCassandraTable(
      "elections",
      "votesparty")

    votes_groupBy_party.write
      .format("org.apache.spark.sql.cassandra")
      .options(Map("table" -> "votesparty", "keyspace" -> "elections"))
      .save()
  }
}