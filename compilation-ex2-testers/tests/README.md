# L Parser Test Suite

Comprehensive testing suite for the CUP-based L programming language parser.

## Quick Start

```bash
# Build the parser
make

# Run all tests
make test

# Run tests by category
make test-lexer       # Lexical analysis tests
make test-parser      # Syntax analysis tests
make test-precedence  # Operator precedence tests
make test-errors      # Error detection tests
make test-edge        # Edge case tests
make test-ast         # AST verification tests

# View test summary
make test-summary
```

## Test Statistics

- **Total Test Files**: 106
- **Total Expected Outputs**: 106
- **Test Categories**: 6

### Breakdown by Category

| Category | Test Files | Description |
|----------|------------|-------------|
| Lexical Analysis | 17 | Valid tokens (8) + Lexical errors (9) |
| Syntax Analysis | 38 | Valid syntax (35) + Complete programs (3) |
| Operator Precedence | 19 | All 8 precedence levels + associativity |
| Error Detection | 11 | Syntax errors with line numbers |
| Edge Cases | 14 | Boundary conditions and special cases |
| AST Verification | 7 | AST structure and line number validation |

## Directory Structure

```
tests/
├── lexer/
│   ├── valid/          # Valid lexical tests
│   └── errors/         # Lexical error tests
├── parser/
│   ├── valid/          # Valid syntax tests
│   └── complete/       # Complete program tests
├── precedence/         # Operator precedence tests
├── errors/
│   └── syntax/         # Syntax error tests
├── edge_cases/         # Edge case tests
├── ast/                # AST verification tests
├── expected/           # Expected output files (mirrors structure)
├── results/            # Test results (generated, .gitignored)
├── run_tests.sh        # Main test runner
├── verify_errors.sh    # Error line number verifier
├── verify_ast.sh       # AST visualization helper
├── dump_ast.sh         # AST dump utility
├── summary_report.sh   # Test statistics generator
├── COVERAGE.md         # Detailed test coverage report
└── README.md           # This file
```

## Test Scripts

### run_tests.sh

Main test runner with colored output.

```bash
./run_tests.sh [category]

# Examples:
./run_tests.sh all        # Run all tests (default)
./run_tests.sh lexer      # Run only lexer tests
./run_tests.sh parser     # Run only parser tests
```

**Output Format:**
- 🟢 `[PASS]` - Test passed
- 🔴 `[FAIL]` - Test failed (shows expected vs actual)
- 🟡 `[SKIP]` - Test skipped (missing expected output)

### verify_errors.sh

Verifies that syntax error tests report correct line numbers.

```bash
./verify_errors.sh

# Checks all tests in errors/syntax/ and errors/lexical/
# Validates ERROR(N) format and line number accuracy
```

### verify_ast.sh

Generates and displays AST visualization for a test file.

```bash
./verify_ast.sh <test_file.txt>

# Example:
./verify_ast.sh precedence/prec_arith_mixed.txt

# Generates: output/ast.jpeg
# Opens with: eog (or xdg-open)
```

### dump_ast.sh

Shows textual AST representation in DOT format.

```bash
./dump_ast.sh <test_file.txt>

# Example:
./dump_ast.sh ast/ast_precedence.txt

# Displays DOT format on stdout
```

### summary_report.sh

Generates test suite statistics.

```bash
./summary_report.sh

# Shows:
# - Test count by category
# - Grand total
# - Expected output file count
# - Infrastructure list
```

## Test File Naming Convention

- **Valid tests**: Descriptive name (e.g., `var_dec_simple.txt`)
- **Error tests**: Descriptive with error type (e.g., `missing_semicolon_line5.txt`)
- **Expected outputs**: Same name with `.out` extension (e.g., `var_dec_simple.out`)

## Expected Output Format

- **Valid programs**: `OK`
- **Lexical errors**: `ERROR` (no line number)
- **Syntax errors**: `ERROR(N)` where N is the line number

## Creating New Tests

1. **Create test file** in appropriate category:
   ```bash
   echo "int x;" > tests/parser/valid/my_test.txt
   ```

2. **Create expected output**:
   ```bash
   echo "OK" > tests/expected/parser/my_test.out
   ```

3. **Run the test**:
   ```bash
   make test-parser
   ```

## Coverage Report

See [COVERAGE.md](COVERAGE.md) for detailed test coverage information, including:
- Requirements traceability matrix
- Test-to-requirement mapping
- Success criteria validation
- Known limitations

## Integration with CI/CD

The test suite can be integrated into continuous integration:

```bash
#!/bin/bash
# ci-test.sh

make clean
make
make test

# Check exit code
if [ $? -eq 0 ]; then
    echo "All tests passed!"
    exit 0
else
    echo "Some tests failed!"
    exit 1
fi
```

## Debugging Failed Tests

When a test fails:

1. **Check the actual output**:
   ```bash
   cat tests/results/<test_name>.out
   ```

2. **Compare with expected**:
   ```bash
   diff tests/results/<test_name>.out tests/expected/<category>/<test_name>.out
   ```

3. **Run with debug mode** (if valid test):
   ```bash
   make debug INPUT=tests/<category>/<test_name>.txt
   # View AST: output/ast.jpeg
   ```

4. **Check parser output**:
   ```bash
   java -jar PARSER tests/<category>/<test_name>.txt /tmp/debug.out
   cat /tmp/debug.out
   ```

## Requirements Mapping

All tests map to requirements in:
- `hw1.md` - Lexical analysis requirements
- `hw2.md` - Syntax analysis requirements
- `/specs/001-cup-parser-implementation/spec.md` - Functional requirements

See COVERAGE.md for the complete traceability matrix.

## Test Development Timeline

1. ✅ Infrastructure setup
2. ✅ Lexical analysis tests (17)
3. ✅ Syntax analysis tests (38)
4. ✅ Operator precedence tests (19)
5. ✅ Error detection tests (11)
6. ✅ Edge case tests (14)
7. ✅ AST verification tests (7)
8. ✅ Documentation (COVERAGE.md, README.md)

## Contributing

When adding new tests:
- Follow existing naming conventions
- Create both input (.txt) and expected output (.out)
- Update COVERAGE.md if testing new requirements
- Run full test suite to ensure no regressions

## Support

For issues or questions:
- Check COVERAGE.md for test details
- Review hw1.md and hw2.md for language specifications
- Examine existing test files for examples

---

**Generated**: 2025-11-26
**Test Suite Version**: 1.0
**Total Tests**: 106
**Coverage**: 100% of specified requirements
