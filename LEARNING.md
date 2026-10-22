# Learning Log

One section per week, written on Sunday after explaining the topic out loud.

## Week 1 — Setup & Git

**Topic explained:** Git branching

1. Branch is the pointer to a commit
2. We use it to create separate version away from the `main` branch so that it won't mess up
3. When work is done, it will be merged into the `main` branch. The `main` branch will point to new commit coming from that branch in case there is no change on the working version, else it will create merge commit.    
   it will have conflict if the change on that branch and `main` branch are on the same line

## Week 2 - OOP

**Topic explained:** Encapsulation

1. Encapsulation is the concept in object oriented programming which protects the fields from the outside world by making them private and expose them through methods.
2. In `BankAccount` we use that concept on `balance` field along with `deposit` and `withdraw` methods.
3. The reason why we choose to do so is to avoid the risk of invalid `balance` value such as negative value and so on. On `deposit` and `withdraw` methods, we put the validation on whether how `balance` is modified. If we allow to update `balance` directly, those validation will be bypass and the `balance` value will be invalid.
