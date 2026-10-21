# Java Journey Handbook

What I've learned so far, written as a reference to come back to.
One section per day, plus cheat sheets at the end.
Examples are small and separate from my exercises.

Covers: Week 1, Mon → Week 2, Fri (2026-10-08 → 2026-10-21)

---

## Week 1 — Setup & Git

### Mon — JDK, IntelliJ, `javac` / `java`

**Big idea:** Java source (`.java`) is compiled to bytecode (`.class`), and the JVM runs the bytecode.

```
Greeter.java  --javac-->  Greeter.class  --java-->  runs on the JVM
```

**Running from the terminal**

```bash
cd src
javac Greeter.java     # compile → creates Greeter.class
java Greeter           # run — class name, no ".class"
```

**Rules to remember**
- The file name must match the `public class` name: `public class Greeter` lives in `Greeter.java`.
- The entry point is always `public static void main(String[] args)`.
- Class names use PascalCase (`Greeter`, not `greeter`).

**Project structure in IntelliJ:** code goes in `src/`, and IntelliJ puts compiled output in `out/`.
For the first 12 weeks pick the plain **IntelliJ** build system, not Maven (Maven starts in week 13).

**Dates (bonus I used):** `java.time.LocalDate` + `DateTimeFormatter`

```java
LocalDate d = LocalDate.of(2026, 1, 5);
System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(d)); // 05/01/2026
```

Pattern letters: `yyyy` year, `MM` month number, `MMMM` month name, `dd` day, `EEEE` weekday name.

**Lesson learned:** I picked Maven in the new-project wizard by mistake. Check the build system before clicking Create.

---

### Tue — Git basics & `.gitignore`

**Big idea:** Git takes snapshots (commits) of your project. A file moves through three places:

```
working directory  --git add-->  staging area  --git commit-->  history
```

| Command | What it does |
| --- | --- |
| `git init` | Turn the current folder into a repo |
| `git status` | What's changed, staged, untracked |
| `git add <file>` / `git add .` | Stage changes |
| `git commit -m "msg"` | Save a snapshot of what's staged |
| `git log --oneline` | Show history, one line per commit |
| `git rm --cached <file>` | Stop tracking a file but keep it on disk |

**`.gitignore`** lists files Git should not track. Ignore anything a tool *generates*:

```
out/          # compiled output
*.class       # bytecode
.idea/        # IntelliJ settings
*.iml         # IntelliJ module files
.DS_Store     # macOS Finder junk
```

**Lesson learned:** `.gitignore` only affects *untracked* files. If a file was already committed, adding it to `.gitignore` does nothing until you run `git rm --cached <file>` and commit.

**How to spot generated files:** ask "did I type this, or did a tool create it?" If a tool created it and can recreate it, ignore it.

**Commit message style:** `week01: add Calculator` — folder, colon, verb in the present tense.

---

### Wed — GitHub, remotes, push, Markdown

**Big idea:** a *remote* is just a named URL pointing at another copy of your repo (e.g. on GitHub). `origin` is the usual name for it.

```bash
git remote add origin https://github.com/<user>/<repo>.git
git remote -v                 # list remotes
git push -u origin main       # first push
git push                      # every push after that
```

`-u` (upstream) remembers "my `main` goes to `origin/main`", so later you can type just `git push`.

**Markdown basics** (used for README files)

```markdown
# Heading 1
## Heading 2
**bold**, *italic*, `inline code`
- bullet
- [ ] task list item
- [x] done item
[link text](docs/file.md)
```

---

### Thu — Branches, merge, merge conflicts (+ `Scanner`, `switch`)

**Big idea:** a branch is a movable label pointing at a commit. You work on a branch, then merge it back.

```bash
git switch -c feature/x     # create + switch (older: git checkout -b)
git switch main
git merge feature/x
git branch                  # list branches
```

**Fast-forward merge:** if `main` has no new commits since the branch started, Git just moves the `main` label forward. No merge commit is created.

```
before:  main → A ← feature/x is at C (A—B—C)
after:   main → C
```

**Merge commit:** if both branches have new commits, Git creates a new commit with two parents.

**Merge conflict:** both branches changed the same lines differently. Git marks the file:

```
<<<<<<< HEAD
color = blue
=======
color = red
>>>>>>> feature/x
```

To resolve: edit the file to the version you want, delete the markers, then `git add` the file and `git commit`.

**Lessons learned**
- My first conflict attempt merged cleanly. Git compares each side to the *merge base* (the common ancestor), and my branch's net change was zero, so there was nothing to conflict with.
- `AM` in `git status --short` = **A**dded (staged) and then **M**odified again. The second edit isn't staged yet, so run `git add` again before committing.

**Java bits from the calculator**

Reading input with `Scanner`:

```java
Scanner in = new Scanner(System.in);
System.out.print("Name: ");
String name = in.nextLine();
int age = Integer.parseInt(in.nextLine());   // read a line, then convert
```

`switch` on a String (classic form — don't forget `break`):

```java
switch (day) {
    case "SAT":
    case "SUN":
        System.out.println("weekend");
        break;
    default:
        System.out.println("weekday");
}
```

Formatted output: `System.out.printf("%.2f%n", 3.14159);` → `3.14` (`%n` = newline).

**Division by zero:**
- `int`: `5 / 0` throws `ArithmeticException` (crash).
- `double`: `5.0 / 0` gives `Infinity`, `0.0 / 0` gives `NaN`. No crash, but a meaningless answer, so check for 0 yourself.

---

### Fri — The debugger

**Big idea:** instead of adding `println` everywhere, pause the program and look at the variables.

| Tool | What it does |
| --- | --- |
| Breakpoint | Click in the gutter; the program pauses *before* that line runs |
| Debug (bug icon) | Run with breakpoints active (Run ▶ ignores them) |
| Step Over (F8) | Run the current line, stop at the next one |
| Step Into (F7) | Go inside the method being called |
| Step Out (⇧F8) | Finish the current method, go back to the caller |
| Resume (⌥⌘R) | Run until the next breakpoint |
| Variables pane | Current values of every local variable |
| Watches | Expressions you want to track, e.g. `total * 2` |
| Conditional breakpoint | Right-click a breakpoint → condition, e.g. `i == 99`; pauses only when true |

**Off-by-one bugs:** a loop that runs one time too many or too few. Check the boundaries.

```java
for (int i = 0; i < 3; i++)   // i = 0, 1, 2   → 3 times
for (int i = 1; i <= 3; i++)  // i = 1, 2, 3   → 3 times
for (int i = 1; i < 3; i++)   // i = 1, 2      → only 2 times!
```

**Lessons learned**
- Look at the *exit condition* first. Changing where `i` starts didn't matter (adding 0 changes nothing); the bug was where the loop stopped.
- A conditional breakpoint on the `for (...)` line can't see `i`, because `i` doesn't exist yet when that line is first reached. Put it on a line **inside** the loop body.

---

### Sat — LibraryHub v0.1: menu loop + array storage

**Big idea:** a fixed-size array has a **capacity** (how many slots exist) and a **count** (how many slots you've filled). Java tracks the capacity for you (`arr.length`); you track the count yourself with one counter.

```java
String[] names = new String[5];   // capacity 5, every slot starts as null
int size = 0;                     // count — also the next free index

names[size] = "Ana";  size++;     // slot 0, size = 1
names[size] = "Bo";   size++;     // slot 1, size = 2

if (size >= names.length) { /* full — refuse instead of crashing */ }

for (int i = 0; i < size; i++) {             // loop to size, not length
    System.out.println((i + 1) + ". " + names[i]);   // humans count from 1
}
```

Writing past the last slot (`names[5]`) throws `ArrayIndexOutOfBoundsException`, so always check before adding.

**Menu loop pattern:** repeat until the user chooses to stop. The number of rounds isn't known in advance, so use `while`.

```java
boolean running = true;
while (running) {
    // show menu, read choice
    switch (choice) {
        case 1: /* ... */ break;
        case 9: running = false; break;
        default: System.out.println("Unknown option");
    }
}
```

Alternative: `while (true)` plus `break` (note: inside a `switch`, `break` leaves only the `switch`, not the loop, which is one reason the flag version reads more clearly).

**Making an existing folder an IntelliJ module:** File → New → Module → Java. Set **Location** to the *parent* folder and **Name** to the folder name; check the full path preview before Create. Setting Location to the folder itself gives a nested `name/name/`.

**Lessons learned**
- Don't build what you already have: the add-counter already *is* the count, so no "count the non-null slots" function is needed. This is how `ArrayList` works inside (an array plus a size).
- Use `arr.length` instead of repeating a magic number like `100`.
- When a task is unclear ("list books"), sketch the expected console output first.
- Still open: `Integer.parseInt` crashes on letters or an empty line (fix in Week 6, exceptions).

---

### Sun — Review: explaining Git branching

**Big idea:** a branch is a cheap, movable **pointer to a commit**, not a copy of the code. Branches share history; only the label differs.

```
A ← B ← C        main
         ↖
          D ← E  feature/login     ← this label moved C → D → E as I committed
```

**`HEAD`** is a pointer to the branch you're on: `HEAD → branch → commit`. When you commit, the branch that HEAD points to moves forward. `git switch` moves HEAD.

```bash
cat .git/HEAD        # ref: refs/heads/main
```

**Merging, two cases**
- `main` didn't move since branching → **fast-forward**: the `main` label slides up, no new commit.
- `main` has its own new commits → **merge commit** with two parents.
- Both sides changed the same lines → **conflict**: fix by hand, `git add`, `git commit`.

**How to explain it in an interview:** short sentences, say "I", use something you actually built ("I made `feature/calc`, committed there, `main` stayed clean, then merged — it was a fast-forward"). A memorised, too-perfect answer sounds scripted.

**Lessons learned**
- "Copy" is the wrong word for a branch: creating one only writes down a commit ID.
- Not every merge creates a merge commit. Say "`main` moves forward to include the work" to cover both cases.
- `LEARNING.md` now has a weekly template: copy the `## Week N` block each Sunday.

---

## Week 2 — Classes, Objects, Encapsulation

### Mon — Class vs object, fields, methods, `new`

**Big idea:** a **class** is a blueprint; an **object** is one thing built from it. One class, many objects, and each object has its own copy of the fields.

```java
class Dog {
    String name;                        // field: data each object holds
    int age;

    String greet() {                    // method: behaviour that uses the fields
        return name + " says woof";
    }
}

Dog a = new Dog();                      // new → builds an object, gives back a reference
a.name = "Rex";                         // dot = "this object's field"
System.out.println(a.greet());          // Rex says woof
```

**A variable holds a reference, not the object**

```java
Dog c = a;          // no new → no new object; c and a point to the same dog
c.name = "Max";     // a.name is now "Max" too
```

**Default values for fields:** `String` (any object) → `null`, `int` → `0`, `boolean` → `false`.

**Printing an object without help:** `println(dog)` shows `Dog@1b6d3586`, which is the class name + `@` + the hash code in hex. It's not a guaranteed memory address. Fix it with a method that builds readable text (and on Thursday: `toString()`).

**Return vs print:** a method that *returns* a `String` is more reusable than one that prints: the caller decides where it goes (console, menu, file).

```java
String.format("%s is %d years old", name, age)   // %s text, %d whole number
```

**One job per class:** the model class (`Dog`) describes the thing; a separate `Main` runs the program. `main` would *work* inside `Dog`, but it mixes two jobs.

**Lessons learned**
- `String` has a capital S because it's a class; `int` is a primitive.
- Use a plain method first; `toString()` is the same idea with a special name Java calls for you.

---

### Tue — Constructors, overloading, `this`

**Big idea:** a **constructor** runs once, when `new` builds the object, and sets up its starting state. It has the class's name and **no return type** (not even `void`).

**Overloading:** several constructors (or methods) with the same name but different parameter lists. Java picks the one whose parameters match the call.

```java
public class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {   // the "full" constructor does the real work
        this.name = name;                // this.name = the field, name = the parameter
        this.age = age;
    }

    public Dog(String name) {            // shorter version delegates to the full one
        this(name, 0);
    }
}

new Dog("Rex");       // calls Dog(String)        → age 0
new Dog("Rex", 3);    // calls Dog(String, int)   → age 3
```

**Two jobs of `this`**
- `this.field`: "the field of this object." You need it when a parameter has the same name (`name = name;` just assigns the parameter to itself).
- `this(...)`: "call another constructor of this class." It keeps the setup logic in **one place** (no copy-pasted assignments).

**No constructor written?** Java gives you an empty no-arg one for free. Once you write *any* constructor, that free one disappears.

**Java 25: flexible constructor bodies.** Statements may come *before* `this(...)` / `super(...)`, but they can't use `this` or the object's fields, because the object isn't set up yet. Main use: checking arguments before delegating.

```java
public Dog(String name) {
    System.out.println("making a dog");   // ✅ ok
    // System.out.println(this.name);     // ❌ compile error
    this(name, 0);
}
```

**Money formatting:** `String.format("%.2f", 3.5)` → `3.50` (two decimals).

**`ClassNotFoundException: Main` when the code is fine:** the JVM can't find a compiled `Main.class`, which means the run setup is wrong (wrong module, module not compiled, stale run configuration after a rename). Check how you're running it before changing the code.

**Lessons learned**
- Delegating with `this(...)` beats copying assignments: if a rule changes, you change one constructor.
- A runtime "class not found" error is about the build/run setup, not your Java.
- IntelliJ's Rename can also edit text in other files (docs, comments). Read the preview before confirming.
- A constructor that accepts anything (e.g. a negative starting balance) "works" but lets the object start in an invalid state.

---

### Wed — `private`, getters / setters, encapsulation

**Big idea:** **encapsulation** = the class guards its own data. Fields are `private`; the outside world changes them only through methods that enforce the rules. If there's a way around the rules, the rules don't exist.

```java
public class Thermostat {
    private int target;                      // nobody outside can touch it directly

    public int getTarget() {                 // getter: read access
        return target;
    }

    public boolean setTarget(int degrees) {  // the only way in, and it checks
        if (degrees < 10 || degrees > 30) {
            return false;                    // rejected: state unchanged
        }
        target = degrees;
        return true;
    }
}
```

**Getter yes, setter maybe.** Don't add a setter by reflex. Ask "should anyone be allowed to set this to *any* value?" For a counter, a balance or a stock level, the answer is no: offer meaningful operations (`increment`, `deposit`, `restock`) instead of `setX`.

**Reporting failure: `boolean` return vs exception**

| | `return false` | `throw new IllegalArgumentException(...)` |
| --- | --- | --- |
| Caller must... | check the result | catch it, or the program stops |
| If ignored | silently nothing happens | crash with a message |
| Good for | expected "no" answers (not enough stock) | programming errors, bad input that should never happen |

```java
if (!thermo.setTarget(50)) {
    System.out.println("Out of range");
}
```

**Constructors can't return `false`**, so for bad constructor arguments the choices are: silently fix the value (e.g. clamp to 0) or **fail fast** by throwing. Failing fast is usually better: a silent fix hides a bug (a typo of `-500` for `500` goes unnoticed until much later).

```java
public Thermostat(int target) {
    if (target < 10 || target > 30) {
        throw new IllegalArgumentException("target out of range: " + target);
    }
    this.target = target;                    // check first, then assign
}
```

Put the check in the "full" constructor only: the shorter constructors delegate with `this(...)` and are covered automatically.

**Boundaries matter:** decide whether the edge value is allowed, then pick the operator. "Reject if more than the balance" is `amount > balance`, so withdrawing exactly the balance succeeds. `>=` there would be an off-by-one.

**Lessons learned**
- I listed every failure case (negative, zero, too large) *before* writing the method. Code then followed the list.
- Validate the same rule everywhere state can change: `deposit`, `withdraw` **and** the constructor.
- `0` can be valid in one place (opening balance) and invalid in another (deposit amount). Check each rule separately.

---

### Thu — `static` fields and methods, `toString()`

**Big idea:** a normal field belongs to **each object**; a `static` field belongs to **the class**, so there is exactly one copy shared by every object.

```java
public class Ticket {
    private static int lastIssued = 500;   // one copy, shared by all tickets
    private int number;                    // one per ticket

    public Ticket() {
        lastIssued++;                      // bump the shared counter...
        this.number = lastIssued;          // ...and copy it into this object
    }
}

new Ticket();   // number 501
new Ticket();   // number 502
```

| | Instance field | `static` field |
| --- | --- | --- |
| How many copies | one per object | one for the whole class |
| Accessed as | `obj.field` / `this.field` | `ClassName.field` |
| Typical use | this object's data (name, balance) | counters, shared constants |

**`static` methods** belong to the class too: call them as `Math.max(a, b)`, no object needed. They can't use `this` or instance fields, because there is no "this object".

**Increment-then-assign vs assign-then-increment:** both work, but the starting value has to match.

```java
static int next = 501;   this.number = next++;   // hand out, then bump
static int last = 500;   this.number = ++last;   // bump, then hand out
```

Name the counter for what it actually holds: `next...` if it's the number to give out *next*, `last...` if it's the one *already given out*.

**Where to put once-per-object logic:** in the constructor that does **not** call `this(...)`. Every other constructor delegates there, so each object passes through it exactly once.

**Order matters:** validate (and maybe `throw`) **before** touching the shared counter. Otherwise a failed `new` uses up a number and leaves a gap.

**`toString()`:** every class inherits it from `Object` (default: `ClassName@hashInHex`). Override it and `println(obj)` and `"text " + obj` call yours automatically.

```java
@Override
public String toString() {
    return String.format("Ticket #%d", number);
}

System.out.println(t);   // Ticket #501
```

`@Override` asks the compiler to check that you really are overriding. A typo like `tostring()` then becomes a compile error instead of a silent new method.

**Lessons learned**
- Once `toString()` exists, a separate `describe()` doing the same job is duplication. Keep one.
- A getter's name should say what it returns: `getAccountNumber()` returns a number; `getAccount()` sounds like it returns an account.
- Test every path: with two constructors, create objects with **both** to prove each gets numbered.

---

### Fri — Packages, imports, the 4 access levels

**Big idea:** a **package** groups related classes and gives them a namespace. The `package` line at the top of a file must match its folder under `src/`.

```
src/zoo/animals/Cat.java   →  package zoo.animals;
src/zoo/app/ZooApp.java    →  package zoo.app;
```

**Imports:** you need one to use a class from a **different** package. Classes in the same package (and `java.lang`, e.g. `String`, `Math`) need no import.

```java
package zoo.app;

import zoo.animals.Cat;   // full name: package + class
```

**The 4 access levels** (from most open to most closed)

| Keyword | Same class | Same package | Subclass (other package) | Everywhere |
| --- | --- | --- | --- | --- |
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| *(none)* package-private | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

```java
package zoo.animals;

public class Cat {
    String nickname;                       // package-private: only zoo.animals sees it
    private int lives = 9;                 // only Cat sees it
    public String getName() { return "Tom"; }   // anyone
}
```

**Subpackages are separate packages.** `zoo.animals.big` can't see package-private members of `zoo.animals`. The dots only look like nesting.

**Moving classes into packages breaks hidden access.** While everything sits in the default package, a missing keyword still works. Once the caller moves to another package, every package-private constructor or method becomes a compile error: `... is not public in ...; cannot be accessed from outside package`.

**IntelliJ:** right-click `src` → New → Package, then drag files in. It rewrites the `package` lines and adds imports for you.

**Rule of thumb:** start everything `private`, then open up only what another class really needs. Model classes go in `.model`, the runner in `.app`.

**Lessons learned**
- Predict the compile error before running: if it compiles first time, know *why* (here: the API was already `public`).
- A helper that only its own class calls can be `private`, which is tighter than package-private.

---

## Cheat sheets

### Git

```bash
git status                     # always check first
git add . && git commit -m "weekNN: verb something"
git push
git log --oneline --graph --all   # see branches and merges
git switch -c feature/name     # new branch
git merge feature/name         # merge into current branch
git rm --cached file           # untrack, keep on disk
cat .git/HEAD                  # which branch HEAD points to
```

Branch = pointer to a commit · HEAD = pointer to the current branch · merge = fast-forward (no new commit) or merge commit (two parents)

### Java so far

| Thing | Example |
| --- | --- |
| Entry point | `public static void main(String[] args)` |
| Print | `System.out.println(x);` / `System.out.printf("%d%n", n);` |
| Read input | `new Scanner(System.in).nextLine()` |
| Text → number | `Integer.parseInt("42")`, `Double.parseDouble("3.5")` |
| Today's date | `LocalDate.now()` |
| Format a date | `DateTimeFormatter.ofPattern("dd MMM yyyy").format(date)` |
| Early exit from `main` | `return;` |
| New array | `String[] a = new String[100];` (slots start as `null`) |
| Array capacity | `a.length` (no brackets — it's a field, not a method) |
| Loop over filled slots | `for (int i = 0; i < size; i++)` |
| Repeat until quit | `while (running) { ... }` + set `running = false` |
| Create an object | `Dog d = new Dog();` |
| Set / read a field | `d.name = "Rex";` / `d.name` |
| Method returning text | `String greet() { return "hi " + name; }` |
| Build formatted text | `String.format("%s (%d)", name, age)` |
| Two decimals | `String.format("%.2f", 3.5)` → `3.50` |
| Constructor | `public Dog(String name) { this.name = name; }` (no return type) |
| Call another constructor | `this(name, 0);` |
| Field vs parameter | `this.name = name;` |
| Hide a field | `private int count;` |
| Getter | `public int getCount() { return count; }` |
| Report success / failure | `public boolean tryX(...) { if (bad) return false; ...; return true; }` |
| Reject bad input loudly | `throw new IllegalArgumentException("why");` |
| Catch it | `try { ... } catch (IllegalArgumentException e) { println(e.getMessage()); }` |
| `if` / `else` layout | `} else {` on one line |
| Shared by all objects | `private static int count = 0;` |
| Call a static method | `Math.max(a, b)` (class name, no object) |
| Bump then use / use then bump | `++n` / `n++` |
| Readable printing | `@Override public String toString() { return ...; }` |
| Declare a package | `package bank.model;` (first line; matches `src/bank/model/`) |
| Use a class from another package | `import bank.model.BankAccount;` |
| Access levels, open → closed | `public` → `protected` → *(none)* → `private` |

### Naming

- Classes: `PascalCase` → `BankAccount`
- Methods and variables: `camelCase` → `sumToN`, `firstNumber`
- Constants: `UPPER_SNAKE_CASE` → `MAX_BOOKS`
- Branches: `feature/short-name`

---

## Mistakes I've made (so I don't repeat them)

1. Picked Maven instead of the IntelliJ build system for a plain project.
2. Committed `.class` and `.iml` files before setting up `.gitignore`.
3. Thought `.gitignore` would untrack files that were already committed.
4. Committed with `AM` status, forgetting the second edit wasn't staged.
5. Blamed the loop's starting value when the bug was the exit condition.
6. Put a conditional breakpoint on the `for` line, where the loop variable doesn't exist yet.
7. Named a class in lowercase (`sum`) instead of PascalCase (`Sum`).
8. Planned a separate "count non-null slots" function when my add-counter already was the count.
9. Wrote `if(` / `for(` without a space; the convention is `if (` / `for (`.
10. Called a branch a "copy" of the repo; it's a pointer to a commit.
11. Said a merge always makes a merge commit; a fast-forward just moves the label.
12. Said `println(obj)` prints the memory address; it's `ClassName@hashCodeInHex`.
13. Blamed the code for `ClassNotFoundException: Main` when the IntelliJ module/run setup was broken.
14. Left an experiment line (`println("hi")`) in real code; delete experiments once you've seen the result.
15. Threw an exception when the task asked for `return false`; reread the "Done when" before choosing how to report failure.
16. Put `else` on its own line after `}`; the convention is `} else {`.
17. Named a getter `getBankAccount()` when it returned an `int` number; the name should match what comes back.
18. Called a counter `...NextNumber` when it held the last number already given out.
19. Tested only one of two constructors; test every path that should behave the same.
