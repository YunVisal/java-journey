# LibraryHub — Design Decisions

## v0.1 — Menu loop with an array (Week 1, Sat)

### Storage: a fixed-size `String` array of 100
- Book titles are stored in a `String` array with 100 slots.
- **Why an array?** `ArrayList` isn't covered until Week 7. A plain array is the
  tool available right now.
- **Why 100?** Not a magic number, just "big enough" for a practice app. An
  array's size is fixed when it's created, so a capacity has to be chosen up front.
- **Planned change:** v0.7 replaces arrays with `List`s, once the limits of a
  fixed-size array (running out of room, removing from the middle) have been felt.

### Tracking books: one counter
- A counter starts at `0` and always points to the **next free index**.
- After each add, the counter goes up by one.
- The same counter is also the **number of books stored**, so no separate
  "count the non-null slots" function is needed.
  - capacity = how many slots exist (100)
  - count = how many slots are filled (the counter)
- Listing books loops only up to the counter, not over all 100 slots.
- This is the same idea `ArrayList` uses inside: an array plus a size counter.

### Full array: check before adding
- If the counter has reached the array's capacity, adding is refused with a
  message, so the program never hits `ArrayIndexOutOfBoundsException`.
- The check should use the array's own length instead of repeating the
  number `100`.

### Menu: a `while` loop
- The menu repeats until the user chooses Exit. The number of rounds isn't
  known in advance, so a `while` loop fits.
- Exiting: `while (true)` plus `break` on choice 3 (an alternative is a
  `boolean running` flag set to `false`).
- Options: `1` Add book, `2` List books, `3` Exit. Any other input shows an
  error and the menu shows again.
