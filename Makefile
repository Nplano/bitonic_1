TESTER=TestBitonic.java BitonicTester.java BasicTestBitonic.java BasicBitonicTester.java
BITONIC=Bitonic.java BitonicInterface.java
MERGER=Merger.java MergerInterface.java
BALANCER=Balancer.java BalancerInterface.java

.PHONY = all clean

all:
	javac $(TESTER) $(BITONIC) $(MERGER) $(BALANCER)

run: run1
run1:
	java TestBitonic
run10:
	java TestBitonic 10
run77:
	java TestBitonic 77
run100:
	java TestBitonic 100
run1000:
	java TestBitonic 1000
clean:
	rm -rf *.class
