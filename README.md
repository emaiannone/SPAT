# SPAT
A _modified_ version of the implemented tool Semantic-and-Naturalness Preserving Auto Transformation [[1]](#1) on https://github.com/Santiago-Yu/SPAT

"This tool is a source-to-source transformation tool that can deal with partial code snippets (programs without dependency information). The transformed code will be semantic-equivalent to the original ones, as well as syntax-naturalness-preserving."


To use this tool, simply type the followed commands:

1. Use Maven to build the project and create a distributable package (JAR file):
```consolo
mvn pacakge
```

2. Run the JAR file:
```consolo
java -jar target/SPAT-1.0.jar [RuleId] [RootDir] [OutputDir] [PathofJre] \& [PathofotherDependentJar]
```

*[RuleId]* is the transformation rule you want to adopt. 

*[RootDir]* is the root directory path in which you put all your code snippets to be transformed. each ".java'' file is regarded as a code snippet. Each file should contain one Java class. For method-level code snippets, users need to warp each method with a "foo'' class.

*[OutputDir]* is the directory path whre you want to store the transformed code snippets.

*[PathofJre]* is the path of *rt.jar* (usually placed in ".../jre1.x.x\_xxx/lib/''})

*[PathofotherDependentJar]* is optional, one can use it to specify additional dependent libraries.

For example, 
```consolo
java -jar target/SPAT-1.0.jar "2" "./RENE-Java-source-code" "./RENE-transformed/rule2" "/usr/local/opt/openjdk@8/libexec/openjdk.jdk/Contents/Home/jre/lib/rt.jar"
```
This command will transform all java files under the "./RENE-Java-source-code" path by the transformation rule 2 "While2For" to the path ".\Benchmarks\9133\\_5". The only dependency is the rt.jar (java runtime). 


## Supported Transformations

##### 	0. LocalVarRenaming:
Replace the local variables' identifiers with new non-repeated identifiers.
##### 	1. For2While
Replace the for statement with an semantic-equivalent while statement.
##### 	2. While2For
Replace the while statement with an semantic-equivalent for statement.
##### 	3. ReverseIfElse
Switch the two code blocks in the if statement and the corresponding else statement. 
##### 	4. SingleIF2ConditionalExp
Change a single if statement into a conditional expression statement.
##### 	5. ConditionalExp2SingleIF
Change a conditional expression statement into a single if statement.
##### 	6. PP2AddAssignment
Change the assignment $x++$ into $x\text{+=}1$.
##### 	7. AddAssignemnt2EqualAssignment
Change the assignment $x\text{+=}1$ into $x:=x+1$.
##### 	8. InfixExpressionDividing
Divide a infix expression into two expressions whose values are stored in temporary variables.
##### 	9. IfDividing
Divide a if statement with a compound condition ($\land$ , $\lor$, or $\lnot$)  into two nested if statements.
##### 	10. StatementsOrderRearrangement
Switch the places of two adjacent statements in a code block, where the former statement has no shared variable with the latter statement.
##### 	11. LoopIfContinue2Else
Replace the if-continue statement in a loop block with if-else statement.
##### 	12. VarDeclarationMerging
Merge the declaration statements into a single composite declaration statement.
##### 	13. VarDeclarationDividing
Divide the composite declaration statement into separated declaration statements.
##### 	14. SwitchEqualSides
Switch the two expressions on both sides of the infix expression whose operator is $=$.
##### 	15. SwitchStringEqual
Switch the two expressions of the String.equal function, such as '123'.equals(x) -> x.equals('123').
##### 	16. PrePostFixExpressionDividing
Divide the pre-or-post expression into two seperated expressions.
##### 	17. Case2IfElse
Change the Switch-Case statements into If-Else statements.




## Datasets

##### Educoder

The Educoder code clone dataset. In the "records.txt" file, each record is a triple (file1,file2,label). For example, (file1,file2,-1) means that it is not a clone, otherwise it is a clone.

##### 9133 benchmark

The 9133 benchmark is selected from BCB benchmark, we use the 9133 instances to evaluate the syntax naturalness, applicability, and  speed of each transformation rule.

##### Java Corpus

This dataset is used to train the Neural Probabilistic Language Model (see below). 

## Links to relevant repositories

1. The Neural Probabilistic Language Model 
	https://github.com/chiaminchuang/A-Neural-Probabilistic-Language-Model
2. Code2vec
	https://github.com/tech-srl/code2vec
3. DeepCom and Hybrid-DeepCom
	https://github.com/xing-hu/EMSE-DeepCom
4. The dataset of DeepCom
	https://github.com/xing-hu/DeepCom
6. ASTNN
	https://github.com/zhangj111/astnn
5. TBCCD
	https://github.com/yh1105/datasetforTBCCD
6. Jobfuscate
	https://www.duckware.com/jobfuscate/index.html


## References
<a id="1">[1]</a>
S. Yu, T. Wang, and J. Wang, “Data augmentation by program
transformation,” Journal of Systems and Software, vol. 190, p.
111304, 2022. doi: https://doi.org/10.1016/j.jss.2022.111304. [Online].
Available: https://www.sciencedirect.com/science/article/pii/S0164121222000541