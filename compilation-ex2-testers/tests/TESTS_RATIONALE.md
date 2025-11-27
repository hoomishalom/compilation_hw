Complete Test Suite Summary

Here's the complete walkthrough of all 107 tests:

Lexical Error Tests (8 tests) - Now correctly contains only lexical errors:

1. comment_type1_invalid - Invalid character in // comment → ERROR
2. comment_type2_invalid - Invalid character in /* */ comment → ERROR
3. comment_type2_unclosed - Unclosed /* comment → ERROR
4. integer_leading_zero - Integer with leading zero → ERROR
5. integer_out_of_range - Integer > 32767 → ERROR
6. invalid_token - Invalid character in code → ERROR
7. string_invalid_chars - String with invalid characters → ERROR
8. string_unclosed - String missing closing quote → ERROR


LEXER VALID TESTS (8 tests) - Tests that verify lexer correctly tokenizes valid 
programs

10. all_tokens - Uses all valid token types in L language
11. comments_type1 - Valid // single-line comments
12. comments_type2 - Valid /* */ multi-line comments
13. identifiers - Valid identifier names (detects UPPER_CASE with _ as invalid)
14. integers_valid - Valid integers (0-32767, no leading zeros)
15. keywords - All L keywords used correctly
16. strings_valid - Valid string literals
17. whitespace_handling - Various whitespace (spaces, tabs, newlines)

PARSER COMPLETE TESTS (3 tests) - Full programs testing complete parsing

18. program_complex - Classes with inheritance, methods, array typedefs
19. program_multi_dec - Multiple top-level declarations (functions, classes,
arrays)
20. program_nested - Nested structures and complex declarations

PARSER VALID TESTS (35 tests) - Individual grammar constructs

Declarations (10 tests):
21. array_typedef - ARRAY ID = type[];
27. class_dec_extends - class Child extends Parent { }
28. class_dec_methods - class with method declarations
29. class_dec_simple - class Name { fields }
34. func_dec_multi_params - func(type id, type id, ...)
35. func_dec_no_params - func()
36. func_dec_one_param - func(type id)
47. var_dec_initialized - type id := value;
48. var_dec_new_array - type id := new type[size];
49. var_dec_new_object - type id := new Type;
50. var_dec_simple - type id;

Function Calls (6 tests):
22. call_method_args - obj.method(arg1, arg2)
23. call_method - obj.method()
24. call_multi_args - func(arg1, arg2, arg3)
25. call_no_args - func()
26. call_one_arg - func(arg)
40. stmt_call - funcCall(); or obj.method();

Expressions (7 tests):
30. exp_binop - Binary operations (+, -, *, /, <, >, =)
31. exp_literals - Integer, string, nil literals
32. exp_parentheses - (exp) grouping
33. exp_var_simple - Variable as expression
37. new_array - new type[size]
38. new_object - new TypeName

Statements (6 tests):
39. stmt_assignment - var := exp;
41. stmt_if_else - if (cond) { } else { }
42. stmt_if_only - if (cond) { }
43. stmt_return_exp - return exp;
44. stmt_return_void - return;
45. stmt_var_dec - type id; or type id := exp;
46. stmt_while - while (cond) { stmts }

Variables (6 tests):
51. var_field_subscript - obj.field[index]
52. var_field - obj.field
53. var_nested_field - obj.field1.field2
54. var_simple - id
55. var_subscript - arr[index]

PRECEDENCE TESTS (20 tests) - Operator precedence and associativity

Associativity Tests (3 tests):
56. assoc_comparison - Left associativity of < and > (1 < 2 < 3)
57. assoc_divide - Left associativity of / (8 / 4 / 2 = 1, not 4)
58. assoc_subtract - Left associativity of - (10 - 5 - 2 = 3, not 7)

Parentheses (2 tests):
59. paren_nested - Nested parentheses ((((exp))))
60. paren_override_mult - Parentheses override precedence 2*(3+4)

Individual Precedence Levels (8 tests):
61. prec01_assignment - := is non-associative (x := y := 5 is ERROR)
62. prec02_equality - == doesn't exist (invalid, expects ERROR)
63. prec02_equality_valid - = is left-associative (1 = 2 = 3)
64. prec03_comparison - < and > have same precedence
65. prec04_additive - + and - have same precedence
66. prec05_multiplicative - * and / have same precedence
67. prec06_array_indexing - [] has high precedence
68. prec07_function_call - () call has high precedence
69. prec08_field_access - . has highest precedence

Mixed Precedence (7 tests):
70. prec_add_mult - * binds tighter than + (2+3*4 = 14)
71. prec_arith_mixed - Mixed arithmetic operators
72. prec_call_add - func() + 1 (call before addition)
73. prec_field_add - obj.field + 1 (field access before addition)
74. prec_mult_add - 3*4+5 vs 3*(4+5)
75. prec_subscript_add - arr[i] + 1 (subscript before addition)

Syntax Error Tests (12 tests) - Now includes keyword_as_identifier:

1. invalid_class_syntax - Missing { after class declaration → ERROR(2)
2. invalid_exp_syntax - Invalid expression syntax → ERROR(2)
3. keyword_as_identifier - Using class keyword as identifier → ERROR(1) ✓ (moved
here)
4. mismatched_brace_close - Extra } without matching { → ERROR(4)
5. mismatched_brace_open - Extra { without matching } → ERROR(3)
6. missing_brace_func_body - Function missing closing } → ERROR(2)
7. missing_paren_func_dec - Function missing closing ) → ERROR(1)
8. missing_semicolon_line1 - Missing ; → ERROR(2)
9. missing_semicolon_line5 - Missing ; in function → ERROR(6)
10. multiple_errors - Multiple syntax errors → ERROR(4)
11. unexpected_eof - File ends unexpectedly → ERROR(3)
12. unexpected_token - Token in wrong position → ERROR(2)


EDGE CASE TESTS (14 tests) - Boundary conditions and special cases

87. array_zero_size - array type = int[0]; (tests if size 0 allowed)
88. comments_only - File with only comments, no code (ERROR)
89. deeply_nested_exp - (((((((exp))))))) deep nesting
90. deeply_nested_stmt - if { if { if { }}} deep nesting
91. empty_file - Completely empty file (ERROR - needs ≥1 declaration)
92. func_empty_return - void func() { return; }
93. func_no_params_empty_body - Invalid per spec (needs ≥1 stmt in funcDec)
94. if_no_else - if without else clause (else is optional)
95. long_program - Large valid program
96. max_complexity - Maximum complexity (all features combined)
97. minimal_valid - Smallest valid program (one declaration)
98. optional_all_omitted - All optional grammar elements omitted
99. optional_all_present - All optional grammar elements present
100. whitespace_only - File with only whitespace (ERROR)

AST TESTS (7 tests) - AST structure validation

101. ast_associativity - AST correctly reflects operator associativity
102. ast_dec_nodes - AST nodes for declarations (var, func, class, array)
103. ast_exp_nodes - AST nodes for expressions (binop, literals, etc)
104. ast_line_numbers - AST nodes store correct line numbers
105. ast_precedence - AST structure matches operator precedence
106. ast_stmt_nodes - AST nodes for statements (if, while, return, etc)
107. ast_var_nodes - AST nodes for variables (simple, field, subscript)

---
Test Coverage Summary:
- Lexical Analysis: 17 tests (9 errors, 8 valid)
- Syntax Analysis: 69 tests (38 valid constructs, 11 errors, 20 precedence)
- Edge Cases: 14 tests (boundary conditions, empty/minimal programs)
- AST Generation: 7 tests (structure and correctness)

Total: 107 tests, 100% passing ✅
