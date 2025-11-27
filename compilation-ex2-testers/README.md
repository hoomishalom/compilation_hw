# ex2 Submission Test Suite

Comprehensive test suite for validating ex2 (CUP Parser) submissions.

## Overview

This test suite contains **117 tests** organized into two categories:

1. **Comprehensive Test Suite** (106 tests) - Detailed unit and feature tests
2. **Official Tests** (11 tests) - Complete program integration tests

## Quick Start

### Running All Tests

Simply drop your submission zip file into this directory and run:

```bash
./run_all_tests.sh <your-submission.zip>
```

Or if there's only one `.zip` file in the directory:

```bash
./run_all_tests.sh
```

### Expected Submission Format

Your submission zip must follow the structure specified in `hw2.md`:

```
<ID>.zip
├── ids.txt
└── ex2/
    ├── Makefile
    ├── cup/
    ├── src/
    └── (other source files)
```

After running `make` in the `ex2/` directory, there must be a runnable jar at `ex2/PARSER`.

The `PARSER` must accept 2 parameters:
- `<input_file>` - Path to input L program
- `<output_file>` - Path to write output

### Output Format

- **Valid programs**: `OK`
- **Lexical errors**: `ERROR`
- **Syntax errors**: `ERROR(N)` where N is the line number

## Test Categories

### 1. Comprehensive Test Suite (106 tests)

Located in `tests/` directory.

#### Lexical Analysis (17 tests)
- **Valid tokens (8 tests)**: Keywords, identifiers, integers, strings, comments
  - `tests/lexer/valid/keywords.txt`
  - `tests/lexer/valid/integers_valid.txt`
  - `tests/lexer/valid/strings_valid.txt`
  - `tests/lexer/valid/comments_type1.txt`
  - `tests/lexer/valid/comments_type2.txt`
  - etc.

- **Lexical errors (9 tests)**: Invalid tokens, unclosed strings, integer range errors
  - `tests/lexer/errors/integer_out_of_range.txt`
  - `tests/lexer/errors/string_unclosed.txt`
  - `tests/lexer/errors/invalid_token.txt`
  - etc.

#### Syntax Analysis (38 tests)
- **Declaration tests (11 tests)**
  - Variable declarations: `tests/parser/valid/var_dec_simple.txt`
  - Function declarations: `tests/parser/valid/func_dec_no_params.txt`
  - Class declarations: `tests/parser/valid/class_dec_simple.txt`
  - Array typedefs: `tests/parser/valid/array_typedef.txt`

- **Statement tests (8 tests)**
  - Assignments: `tests/parser/valid/stmt_assignment.txt`
  - Returns: `tests/parser/valid/stmt_return_exp.txt`
  - Control flow: `tests/parser/valid/stmt_if_else.txt`, `stmt_while.txt`

- **Expression tests (4 tests)**
  - Literals, variables, binary operations, parentheses

- **Variable access tests (5 tests)**
  - Field access, array indexing, nested access

- **Integration tests (3 tests)**
  - Complete programs: `tests/parser/complete/program_complex.txt`

#### Operator Precedence (19 tests)
Tests all 8 precedence levels and left-associativity:
- `tests/precedence/prec03_comparison.txt`
- `tests/precedence/prec04_additive.txt`
- `tests/precedence/prec05_multiplicative.txt`
- `tests/precedence/assoc_subtract.txt` - Tests `10-5-2` = `(10-5)-2`
- `tests/precedence/paren_override_mult.txt` - Tests parentheses override

#### Error Detection (11 tests)
Syntax errors with correct line number reporting:
- `tests/errors/syntax/missing_semicolon_line5.txt` → `ERROR(5)`
- `tests/errors/syntax/unexpected_eof.txt`
- `tests/errors/syntax/mismatched_brace_open.txt`

#### Edge Cases (14 tests)
Boundary conditions and special cases:
- `tests/edge_cases/empty_file.txt` → `ERROR(1)`
- `tests/edge_cases/deeply_nested_exp.txt` - 50+ nested parentheses
- `tests/edge_cases/long_program.txt` - 50+ declarations
- `tests/edge_cases/minimal_valid.txt` - Smallest valid program

#### AST Verification (7 tests)
Tests for AST structure (manual verification required):
- `tests/ast/ast_precedence.txt` - Verify precedence in AST
- `tests/ast/ast_associativity.txt` - Verify associativity in AST
- `tests/ast/ast_line_numbers.txt` - Verify line number tracking

### 2. Official Tests (11 tests)

Located in `official/input/` with expected outputs in `official/expected_output/`.

#### Valid Programs (5 tests)
1. **TEST_01_Print_Primes.txt** - Prime number printing → `OK`
2. **TEST_02_Bubble_Sort.txt** - Bubble sort implementation → `OK`
3. **TEST_03_Merge_Lists.txt** - Merge lists program → `OK`
4. **TEST_04_Matrices.txt** - Matrix operations → `OK`
5. **TEST_05_Classes.txt** - Classes with inheritance → `OK`

#### Error Programs (5 tests)
6. **TEST_06_Print_Primes_Error.txt** → `ERROR(21)`
7. **TEST_07_Bubble_Sort_Error.txt** → `ERROR(...)`
8. **TEST_08_Merge_Lists_Error.txt** → `ERROR(...)`
9. **TEST_09_Matrices_Error.txt** → `ERROR(...)`
10. **TEST_10_Classes_Error.txt** → `ERROR(...)`

Plus:
11. **Input.txt** - Simple test input

## Test Results

The script will output:
- 🟢 `[PASS]` - Test passed
- 🔴 `[FAIL]` - Test failed (shows expected vs actual)
- 🔴 `[CRASH]` - Parser crashed during execution

### Summary Report

After all tests run, you'll see:

```
=====================================
  Test Summary
=====================================
Total:  117
Passed: 117
Failed: 0
Pass Rate: 100%

✓ All tests passed!
```

## Directory Structure

```
ex2-tests/
├── README.md                    # This file
├── run_all_tests.sh            # Main test runner
├── run_category.sh             # Run specific category (future)
├── tests/                      # Comprehensive test suite (106 tests)
│   ├── lexer/
│   │   ├── valid/              # Valid lexical tests
│   │   └── errors/             # Lexical error tests
│   ├── parser/
│   │   ├── valid/              # Valid syntax tests
│   │   └── complete/           # Complete programs
│   ├── precedence/             # Operator precedence tests
│   ├── errors/
│   │   └── syntax/             # Syntax error tests
│   ├── edge_cases/             # Edge case tests
│   ├── ast/                    # AST verification tests
│   ├── expected/               # Expected outputs (mirrors structure)
│   ├── run_tests.sh            # Original test runner (for reference)
│   ├── verify_errors.sh        # Error line verification
│   ├── verify_ast.sh           # AST visualization
│   ├── AstVerifier.java        # Programmatic AST verification
│   ├── README.md               # Test suite documentation
│   └── COVERAGE.md             # Detailed coverage report
├── official/                   # Official tests (11 tests)
│   ├── input/                  # Official input files
│   └── expected_output/        # Official expected outputs
└── workspace/                  # Temporary directory (auto-created/cleaned)
```

## Advanced Usage

### Testing Specific Categories

(Future enhancement)
```bash
./run_category.sh <submission.zip> lexer
./run_category.sh <submission.zip> parser
./run_category.sh <submission.zip> precedence
./run_category.sh <submission.zip> errors
./run_category.sh <submission.zip> edge
./run_category.sh <submission.zip> ast
./run_category.sh <submission.zip> official
```

### Manual Testing

If you want to test manually:

```bash
# Extract your submission
unzip <ID>.zip

# Build
cd ex2
make

# Run on a test
java -jar PARSER ../ex2-tests/official/input/TEST_01_Print_Primes.txt output.txt
cat output.txt  # Should show "OK"
```

### Workspace Directory

The test runner creates a `workspace/` directory that contains:
- Extracted submission
- Build output
- Test results

This directory is automatically cleaned up after tests complete (even on failure).

To preserve it for debugging, comment out the `trap cleanup EXIT` line in `run_all_tests.sh`.

## Requirements Mapping

All tests map to requirements from:
- `hw1.md` - Lexical analysis requirements
- `hw2.md` - Syntax analysis requirements
- Original specification documents

See `tests/COVERAGE.md` for complete requirements traceability matrix.

## Test Coverage

| Category | Test Count | Coverage |
|----------|------------|----------|
| Lexical Analysis | 17 | 100% of lexer requirements |
| Syntax Analysis | 38 | 100% of parser requirements |
| Operator Precedence | 19 | All 8 levels + associativity |
| Error Detection | 11 | All error types |
| Edge Cases | 14 | Boundary conditions |
| AST Verification | 7 | AST structure validation |
| Official Tests | 11 | Integration testing |
| **TOTAL** | **117** | **100%** |

## Troubleshooting

### Build Fails

If the build fails, check:
1. `ids.txt` exists and has correct format
2. `Makefile` exists in `ex2/` directory
3. `Makefile` produces `ex2/PARSER` (not `ex2/PARSER.jar`)
4. No hard-coded paths in `Makefile`

Build log is saved to `workspace/build.log`.

### Parser Crashes

If tests show `[CRASH]`:
1. Parser threw an exception
2. Check stderr output
3. Test manually to see error message

### Wrong Output Format

Expected output formats:
- `OK` (exactly, with newline)
- `ERROR` (for lexical errors)
- `ERROR(N)` (for syntax errors, N is line number)

Common issues:
- Extra whitespace
- Missing newline
- Wrong line number

### Tests Pass But Should Fail

Some tests are designed to fail. Check:
- Test is in `errors/` or has `_Error` in name
- Expected output shows `ERROR` or `ERROR(N)`

## Credits

Tests designed and implemented for Compilation course (0368-3133).

Comprehensive test suite covers all requirements from hw1.md and hw2.md.

## License

For educational use only.
