# Phase 1 Daily Plan — Core Java & OOP

## How the Days Work

Every day is a build task with a clear "done when" check. You write all the code yourself; this plan only tells you what to build and what to learn first.

**Daily rhythm**

- **Mon–Fri (60–90 min):** *Learn* (20–30 min) — look up the listed keywords in the docs or your book. Then *Build* (40–60 min) — do the task until every "done when" point is true. Commit to GitHub.
- **Saturday (3–4 h):** *Weekly build* — add a feature to **LibraryHub**, the running project.
- **Sunday (30 min):** explain the week's topic out loud in 2 minutes, then write 3 lines in your repo's `LEARNING.md`. Rest the rest of the day.

**The running project: LibraryHub**

A console app for managing books, members and loans. It grows a little every Saturday. In Phase 2 you turn it into a Spring Boot REST API, so the code you write now is reused later.

**Repo layout:** one GitHub repo, `java-journey`, with a folder per week (`week01/`, `week02/` …) for the daily tasks and a separate `libraryhub/` folder.

**Rules**

1. Type every line yourself. No copy-paste from tutorials or AI.
2. Stuck for 30 minutes? Ask for a *hint*, not a solution — from docs, Stack Overflow or Claude.
3. Ask Claude for a code review only after your version works.
4. One commit per day minimum, with a clear message (`week03: add Manager salary rules`).
5. Missed a day? Do it the next day and shift the plan. Never skip a topic.

## Month 1 — Setup, Classes, Inheritance, Interfaces

By November 8 you have a working LibraryHub v0.4 built with classes, inheritance and interfaces.

### Week 1 (Oct 12–18) — Setup & Git

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | JDK 25, IntelliJ, `javac` / `java`, project structure | `HelloJava` that prints your name and today's date | Runs from IntelliJ **and** from the terminal |
| Tue | `git init`, `add`, `commit`, `log`, `.gitignore` | Create the `java-journey` repo with `week01/` | `git log` shows 3 commits; IntelliJ files are ignored |
| Wed | GitHub, remotes, `push`, Markdown | Push to GitHub; write a README with your 18-month goal | README renders on GitHub |
| Thu | Branches, `merge`, merge conflicts | On branch `feature/calc`, build a calculator CLI (+ − × ÷) using `Scanner`, then merge | Dividing by zero shows a message instead of crashing |
| Fri | Debugger: breakpoints, step over / into, watches | Write a sum-of-1-to-n method with an off-by-one bug; find it **only** with the debugger | Bug fixed without any `println` |
| Sat | — | **LibraryHub v0.1:** menu loop (1 Add book, 2 List books, 3 Exit), titles stored in an array of 100 | Add 3 books, list them numbered, invalid choice shows an error, exit cleanly |
| Sun | Review | Explain Git branching out loud | 3 lines in `LEARNING.md` |

### Week 2 (Oct 19–25) — Classes, Objects, Encapsulation

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | Class vs object, fields, methods, `new` | `Book` class (title, author, year); create and print 3 books | Output is readable, one book per line |
| Tue | Constructors, overloading, `this` | `BankAccount` (owner, balance) with two constructors | Both constructors work; no duplicated code (use `this(...)`) |
| Wed | `private`, getters / setters, encapsulation | `deposit` and `withdraw` that reject negative amounts and overdrafts | Fields are private; invalid calls return `false` and leave the balance unchanged |
| Thu | `static` fields and methods, `toString()` | Auto-numbered accounts using a static counter; override `toString` | Accounts get numbers 1001, 1002, 1003… |
| Fri | Packages, imports, the 4 access levels | Move classes into `bank.model` and `bank.app` | README explains which access level you used where, and why |
| Sat | — | **LibraryHub v0.2:** replace the String array with `Book` objects (id, title, author, year, available); add Find by title | IDs auto-increment; search ignores upper / lower case |
| Sun | Review | Explain encapsulation with your `BankAccount` | 3 lines in `LEARNING.md` |

### Week 3 (Oct 26–Nov 1) — Inheritance & Polymorphism

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | `extends`, `super(...)` | `Employee` (name, baseSalary) → `Engineer`, `Manager` | Subclasses reuse the parent constructor |
| Tue | Overriding, `@Override` | `calculateSalary()`: Engineer +10%, Manager +20% plus 500 per direct report | Each type prints the correct salary |
| Wed | Polymorphism, upcasting, dynamic dispatch | Total payroll over an `Employee[]` | No `instanceof` in the payroll loop |
| Thu | `instanceof`, pattern matching, downcasting risks | Print "Manager of N people" only for managers | Uses `if (e instanceof Manager m)` |
| Fri | The `Object` class, `final` methods and classes | Make Manager's `calculateSalary` final; try overriding it in a subclass | Compiler error noted in `LEARNING.md` |
| Sat | — | **LibraryHub v0.3:** `LibraryItem` base class → `Book`, `Magazine` (issue number), `DVD` (minutes); each overrides `getLoanDays()` (14 / 7 / 3) | List shows each item's type and loan days |
| Sun | Review | Explain polymorphism with your payroll code | 3 lines in `LEARNING.md` |

### Week 4 (Nov 2–8) — Abstract Classes & Interfaces

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | Abstract classes and methods | Make `Employee` abstract with abstract `calculateSalary()` | `new Employee(...)` no longer compiles |
| Tue | Interfaces, implementing several | `Payable` and `Taxable`; a `Contractor` (not an Employee) implements `Payable` | Payroll accepts a `Payable[]` with employees and contractors mixed |
| Wed | Default and static interface methods | Default `taxRate()` of 10% in `Taxable`; Manager overrides it with 15% | Net pay is correct for each type |
| Thu | Composition over inheritance | `Department` **has** a `Manager` and an `Employee[]`; add `departmentCost()` | No class extends `Department` |
| Fri | Interface segregation (the I in SOLID), refactoring | Refactor week 3 code so shared behaviour lives in interfaces | Short note in README on what you changed and why |
| Sat | — | **LibraryHub v0.4:** make `LibraryItem` abstract; add a `Borrowable` interface (`borrow`, `returnItem`, `isAvailable`) and a `Member` class; add Borrow / Return menu options | Can't borrow an unavailable item; a member holds at most 3 items |
| Sun | Review | Explain abstract class vs interface — when to use each | 3 lines in `LEARNING.md` |

## Month 2 — Strings, Exceptions, Collections

By December 6, LibraryHub v0.8 saves its data to a file, handles errors cleanly and uses the right collection for each job.

### Week 5 (Nov 9–15) — Strings, Wrappers, equals / hashCode

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | String methods, String immutability, the string pool | `TextUtils` with `isPalindrome`, `countVowels`, `reverseWords` | "A man a plan a canal Panama" counts as a palindrome |
| Tue | `StringBuilder`, why `+` in loops is slow | Build a 100,000-line string with `+` and with `StringBuilder`; time both with `System.nanoTime` | Both timings recorded in `LEARNING.md` |
| Wed | Wrapper classes, autoboxing, `==` vs `equals`, the Integer cache | Small experiments comparing `Integer` 127 vs 128 with `==` | You can explain why the results differ |
| Thu | The `equals` / `hashCode` contract | `Money` (amount, currency) with both methods | Two equal `Money` objects in a `HashSet` give size 1 |
| Fri | Immutability: `final` fields, no setters, defensive copies | Make `Money` immutable; `add()` returns a new object | Adding different currencies is rejected |
| Sat | — | **LibraryHub v0.5:** add an ISBN field; `equals` / `hashCode` by ISBN; block duplicate ISBNs; list shown as aligned columns with `String.format` | Duplicate ISBN rejected with a clear message |
| Sun | Review | Explain why `equals` and `hashCode` must agree | 3 lines in `LEARNING.md` |

### Week 6 (Nov 16–22) — Exceptions & Files

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | Exception hierarchy, `try` / `catch` / `finally` | Input loop that keeps asking until the user types a valid number | Letters never crash the program |
| Tue | Checked vs unchecked, `throws` | Sum numbers from a text file using `Files.readAllLines` | A missing file gives a friendly message |
| Wed | try-with-resources, `BufferedReader` / `BufferedWriter` | Copy a file line by line, adding line numbers | Resources close even when an error happens |
| Thu | Custom exceptions | `InsufficientFundsException` and `InvalidAmountException` for `BankAccount` — you choose which is checked | README justifies your choice |
| Fri | Good practice: never swallow, wrap with a cause, fail fast | Review all your code since week 1 | No empty `catch` blocks left anywhere |
| Sat | — | **LibraryHub v0.6:** exceptions `ItemNotFoundException`, `ItemNotAvailableException`, `MemberLimitExceededException`; save items to CSV on exit, load on start | Data survives a restart; a broken CSV line is skipped with a warning |
| Sun | Review | Explain checked vs unchecked with your own examples | 3 lines in `LEARNING.md` |

### Week 7 (Nov 23–29) — Collections I: List, Set, Queue

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | Collections framework overview, `List`, `ArrayList` | Replace arrays in the bank app with `ArrayList` | No fixed-size arrays remain |
| Tue | `ArrayList` vs `LinkedList`, Big-O basics | Time inserting 100,000 items at the start of each | Results and your explanation in `LEARNING.md` |
| Wed | `HashSet`, `LinkedHashSet`, `TreeSet` | Deduplicate a list of emails, once keeping order, once sorted | Two correct outputs from the same input |
| Thu | `Iterator`, `ConcurrentModificationException`, `removeIf` | Remove inactive accounts three ways, including one that throws | You can explain why the failing version fails |
| Fri | `Queue`, `Deque`, `ArrayDeque`, `PriorityQueue` | Print-job simulator where urgent jobs go first | Jobs with equal priority keep arrival order |
| Sat | — | **LibraryHub v0.7:** all arrays become `List`s; a waiting list (`Queue<Member>`) per item; on return, the next member gets it | Waiting list is first-come, first-served |
| Sun | Review | Explain when to pick a List, a Set or a Queue | 3 lines in `LEARNING.md` |

### Week 8 (Nov 30–Dec 6) — Collections II: Map & Sorting

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | `Map`, `HashMap`, `getOrDefault`, `merge` | Word-frequency counter for a text file | Top 10 words printed |
| Tue | How `HashMap` works inside: buckets, collisions, load factor, resizing | Class whose `hashCode` returns a constant; time 50,000 inserts vs a proper `hashCode` | You can draw a HashMap bucket on paper |
| Wed | `TreeMap`, `LinkedHashMap` | LRU cache of size 3 using `LinkedHashMap` | Least-recently-used entry is dropped first |
| Thu | `Comparable`, `Comparator.comparing().thenComparing()` | Sort employees by department, then salary from high to low | One chained comparator, no manual sorting loop |
| Fri | `List.of`, `Map.of`, unmodifiable collections | Getters return unmodifiable views | Changing a returned list throws an exception |
| Sat | — | **LibraryHub v0.8:** `Map<String, LibraryItem>` keyed by ISBN; loans as `Map<Member, List<LibraryItem>>`; reports: top 3 most-borrowed items, items sorted by year then title | ISBN lookup never loops through a list |
| Sun | Review | Explain how `HashMap` finds a key | 3 lines in `LEARNING.md` |

## Month 3 — Generics, Lambdas, Streams, Modern Java, Testing

By January 10, 2027, you release LibraryHub v1.0: a tested Maven project written in modern Java style.

### Week 9 (Dec 7–13) — Generics

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | Generic classes, type parameters | `Box<T>` and `Pair<K, V>` | Used with 3 different types, no casts |
| Tue | Generic methods | `swap(T[] arr, int i, int j)` and `max(List<T>)` for comparable types | Works for `Integer` and `String` lists |
| Wed | Bounded types (`<T extends Number>`) | `Statistics<T extends Number>` with average, min, max | `Statistics<String>` doesn't compile |
| Thu | Wildcards: `? extends`, `? super` (PECS) | `sum(List<? extends Number>)` and `copy(dest, src)` with wildcards | You can explain PECS in one sentence |
| Fri | Type erasure and its limits | Try `new T()` and `new T[10]`; fix with a `Class<T>` parameter | Errors and the workaround noted in `LEARNING.md` |
| Sat | — | **LibraryHub v0.9:** generic `Repository<T, ID>` (save, findById, findAll, delete) plus an `InMemoryRepository`; items and members both use it | No duplicated storage code (this idea returns as Spring Data in Phase 2) |
| Sun | Review | Explain why generics beat `Object` + casting | 3 lines in `LEARNING.md` |

### Week 10 (Dec 14–20) — Lambdas & Optional

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | Lambda syntax, functional interfaces | Rewrite week 8 comparators as lambdas | No anonymous classes left |
| Tue | `Predicate`, `Function`, `Consumer`, `Supplier` | Generic `filter(List<T>, Predicate<T>)`, used for 3 different filters | One method, three uses |
| Wed | Method references (4 kinds) | Replace lambdas with method references where they fit | One example of each kind noted |
| Thu | Composing: `and`, `or`, `negate`, `andThen` | Filter: (salary above X **and** department Y) **or** is a manager | Built from small named predicates |
| Fri | `Optional`: `map`, `orElse`, `orElseThrow`; misuse to avoid | `Repository.findById` returns `Optional<T>` | No `.get()` without a check |
| Sat | — | **LibraryHub v0.10:** search with combinable filters (author, year range, type, available only) built from predicates | No public method returns `null` |
| Sun | Review | Explain what a functional interface is | 3 lines in `LEARNING.md` |

### Week 11 (Dec 21–27) — Streams

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | Pipeline: source → intermediate → terminal; `filter`, `map`, `toList` | Rewrite 3 old loops as streams | Same output as before |
| Tue | `sorted`, `distinct`, `limit`, `anyMatch`, `count` | Make 50 sample orders; find the top 5 by amount and whether any exceed 1,000 | Sample data built with a loop or `Stream.generate` |
| Wed | `reduce`, `IntStream`, `mapToDouble`, `average` | Total revenue and average order value | Uses no `for` loop |
| Thu | `groupingBy`, `counting`, `partitioningBy`, `toMap` | Revenue per customer, orders per month | Results returned as `Map`s |
| Fri | `flatMap`; when a loop is clearer than a stream | All unique products across orders | Note on one loop you chose to keep, and why |
| Sat | — | **LibraryHub v0.11:** stream-based reports: items per type, most popular author, members with no loans | Report code has no `for` loops |
| Sun | Review | Explain lazy evaluation in streams | 3 lines in `LEARNING.md` |

### Week 12 (Dec 28–Jan 3) — Modern Java

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | Records | Convert `Money`, `Pair` and data-holder classes to records | Note on which classes can't become records, and why |
| Tue | Enums with fields and methods | `OrderStatus` enum with allowed transitions | An illegal transition (e.g. DELIVERED → NEW) is rejected |
| Wed | Switch expressions, pattern matching for switch, sealed interfaces | Sealed `Shape` with `Circle`, `Rectangle`, `Triangle` records; area via `switch` | Compiler forces you to handle every shape |
| Thu | `var`, text blocks, `LocalDate`, `Period` | Age calculator plus days until next birthday | Leap years handled |
| Fri | `ZonedDateTime`, time zones, formatting | Meeting-time converter for your city and 2 other time zones | Output formatted as "Mon 14 Jan, 09:00" |
| Sat | — | **LibraryHub v0.12:** `ItemType` enum (loan days, daily late fee) replaces type strings; `Loan` record with borrowed and due dates; overdue report with late fees | Fees correct for 3 test dates you choose |
| Sun | Review | Explain what records give you for free | 3 lines in `LEARNING.md` |

### Week 13 (Jan 4–10, 2027) — Maven, JUnit & Release

| Day | Learn | Build | Done when |
| --- | --- | --- | --- |
| Mon | Maven: `pom.xml`, lifecycle, dependencies, folder layout | Convert LibraryHub to Maven | `mvn package` builds a jar that runs |
| Tue | JUnit 5: `@Test`, assertions, `@BeforeEach` | 5+ tests each for `Money` and `BankAccount` | All green |
| Wed | `@ParameterizedTest`, `assertThrows`, edge cases | Tests for borrow rules: member limit, unavailable item, waiting list | Every rule has a passing and a failing case |
| Thu | Coverage in IntelliJ; what is worth testing | Raise LibraryHub service coverage | 70%+ on service classes |
| Fri | Clean code: naming, small methods, dead code | Refactor and write the README (features, how to run, design) | Then ask Claude for a code review |
| Sat | — | **LibraryHub v1.0:** tag `v1.0` on GitHub with release notes | A friend can run it from your README alone |
| Sun | Phase 1 retro | Tick Phase 1's checklist in the Curriculum tab; write what was hard | Ready for Phase 2 |
