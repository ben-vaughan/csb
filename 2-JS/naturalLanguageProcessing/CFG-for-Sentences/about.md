** CFG for Sentences **

gram_eng_tests lists a few English sentences for which one might try to write a CFG which accepts them ('positive' tests) and also some inputs which the CFG should reject ('negative' tests). The files use a simple format:

blank lines and lines which start with % are ignored.

each test sentence appears on a line of its own.

lines which begin with * indicate negative test, which the grammar ought to reject; the other lines represents input which the grammar ought to accept.

The program example_tester can be passed a grammar and such a test file and it runs tests for acceptance and rejection. For example, if you have copied example_tester to some location, and have the files

simple_np
simple_np_tests
in the same location, the tests could be run with the grammar as follows

./example_tester simple_np simple_np_tests