name := "CassandraExample"
version := "1.0"
scalaVersion := "2.11.7"

val sparkVersion = "1.6.0"

val AkkaVersion = "2.5-SNAPSHOT"

libraryDependencies ++= Seq(
	  // spark core
	  "org.apache.spark" %% "spark-core" % sparkVersion,
	  "org.apache.spark" %% "spark-sql" % sparkVersion,
	  "org.apache.spark" %% "spark-hive" % sparkVersion,
	  "org.apache.commons" % "commons-lang3" % "3.3.2",
	  
	
	   // spark-cassandra
	   "com.datastax.spark" % "spark-cassandra-connector_2.11" % sparkVersion,
	
	  // spark packages
	  "com.databricks" %% "spark-csv" % "1.3.0",
	
	  // testing
	  "org.scalatest"   %% "scalatest"    % "2.2.4"   % "test",
	  "org.scalacheck"  %% "scalacheck"   % "1.12.2"      % "test",
	
	  // logging
	  "org.apache.logging.log4j" % "log4j-api" % "2.4.1",
	  "org.apache.logging.log4j" % "log4j-core" % "2.4.1"
)