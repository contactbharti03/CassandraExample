## Prerequisites

JDK 1.8
Scala 2.11
Spark 1.6
Cassandra 2.0.9

Install and launch a Cassandra cluster.

Configure a new Scala project with the Apache Spark and its dependencies. Check the build.sbt

## Building

To build an assembly jar:

sbt assembly

Preparing example Cassandra schema. For more details check cassandraScript.cql

Create a simple keyspace and table in Cassandra. Using below mentioned commands

CREATE KEYSPACE elections
WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

CREATE TABLE elections.primaryresult 
(id int PRIMARY KEY, state text,state_abbreviation text,county text,fips double,party text,candidate text,votes int,fraction_votes text);

Then insert some example data:

INSERT INTO elections.primaryresult(id, state,state_abbreviation,county,fips,party,candidate,votes,fraction_votes) VALUES (1, 'state','state_abbreviation' ,'county',123.0,'party','candidate',10,'fraction_votes');

Now you're ready to write your first Spark program using Cassandra.
