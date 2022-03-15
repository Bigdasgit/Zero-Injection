REAMDME.txt

==============================================================
ZeroInjection.java
:is a code that builds zeroInjetedMatrix

==============================================================
sample_data
:includes example datas (input, output)

givenMatrix.base is an input data that includes the rating. there are four columns and they are userid, itemid, rating, timestamp (optional)
For example, for one row (1	1	5	874965758)
It means that user 1 give a rating of 5 to the item 1

preUsePrefMatrix.predict is an input data that includes the pre-use preference. there are three columns and they are userid, itemid, pre-use preference.
For example, for one row (1 1    0.8038297)
It means that user 1 has pre-use preference 0.8038297 to item 1

zeroInjectedMatrix.base is an output data that includes the rating and uninteresting items (represent as 0)

==============================================================
utility
:includes java files that needs to run the zero-injection