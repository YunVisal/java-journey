# BankAccount

A small bank account model: auto-numbered accounts (1001, 1002, …), deposits and withdrawals that reject bad amounts.

## Packages

| Package | Class | Job |
| --- | --- | --- |
| `bank.model` | `BankAccount` | The data and its rules |
| `bank.app` | `Main` | Runs the program and uses `BankAccount` |

`Main` lives in a different package, so it needs `import bank.model.BankAccount;` and can only use what `BankAccount` makes `public`.

## Access levels

| What | Access level | Why |
| --- | --- | --- |
| `BankAccount` class | `public` | `Main` is in another package and must be able to see it. |
| Fields `ownerName`, `balance`, `bankAccountNumber` | `private` | Encapsulation: if `Main` could write `balance = -500`, the checks in `deposit` / `withdraw` would mean nothing. The only way to change them is through methods that check the rules. |
| `bankAccountNextNumber` (`static`) | `private` | Only the constructor may hand out numbers. If other code could change the counter, two accounts could get the same number. |
| Constructors, `getBalance`, `getBankAccountNumber`, `deposit`, `withdraw`, `toString` | `public` | They are what the class offers to the outside, so `Main` needs to call them across packages. There are getters but no setters on purpose: balance changes only through `deposit` / `withdraw`. |
| `Main.deposit(...)` / `Main.withdraw(...)` helpers | package-private (no keyword) | They only print messages for `Main`'s own demo. No other package needs them, so they are not `public`. (`private` would be even tighter, because only `Main` calls them.) |
| `protected` | not used | `protected` is about subclasses (inheritance), and nothing extends `BankAccount` yet. |

**Rule I followed:** start as closed as possible (`private`), and open up only what another class really needs.
