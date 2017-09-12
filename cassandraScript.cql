CREATE KEYSPACE elections
WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};

use elections;

drop table primaryResult
create table primaryResult 
(id int PRIMARY KEY, state text,state_abbreviation text,county text,fips double,party text,candidate text,votes int,fraction_votes text);

COPY elections.primaryresult(id, state ,state_abbreviation ,county ,fips ,party ,candidate ,votes ,fraction_votes ) FROM 'F:\data\2016-us-election\primary_results.csv' WITH HEADER=TRUE;