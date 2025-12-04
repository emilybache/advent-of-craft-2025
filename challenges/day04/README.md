# Day 04 - Review the solution

> **Memory fragment – 2023 · Day 4**  
> I remember staring at that code for a long time.  
> Not to change it. Just to understand what it was really doing.  
> The tests were there, but they weren’t telling the story.  
> He tried to rewrite them to capture the behaviour... 
> not the implementation details.  
> ...  
> *Somewhere in there, I learned that reviewing code is also reviewing ideas.*

On the fourth day of the journey, we revisit [a memory from 2023 edition](https://github.com/advent-of-craft/2023/blob/main/docs/exercise/day04/challenge.md) where the focus was not on “making it pass”, but on **understanding and expressing behaviour**.

This time, you’re not the one doing the challenge and submitting the solution.  

**You’re the reviewer.**

---

## Challenge — Review the proposed solution like a real PR

Today’s activation is simple to describe, but rich in nuance:

> Look at the **reference solution** for this exercise  
> as if it were a pull request from a teammate  
> and write a thoughtful code review.

Try to pay attention not only to *what* the code does, but *how* you give feedback.

## Where to play

Pick the stack you want to use as your **main stack** this year and open the proposed solution of Day 4 memory from 2023:

- Proposed solution (what you will review today):  
  `memories/2023/solution/<your-stack>/day04`

You can run the tests if you like, but the emphasis today is on **reading and reviewing**, not on changing everything.

Write down your comments directly in your code as comments to keep track of them and write global observation in a review file or in your journey file.

Let your review tell the story ➰💬

---

## Share with the community

Post your review notes or main takeaways on Discord and get feedback from the community. Don’t hesitate to give respectful feedback on other people’s reviews as well.

Also, if you want your solution to be public, add your file to the  
 - `community/solutions/dayNN/` folder by copying the template located here:  
 - `community/solutions/TEMPLATE-[replace_with_your_name].md`  
and open a pull request (referencing your fork or own pull request).

Use the `journey/your-name.md` file and write an entry for today:

- How did it feel to review an existing solution instead of writing my own?
- What kind of comments did I naturally write (questions, suggestions, nitpicks, praise)?
- What did I learn about **my own review posture** from this exercise?

![snippet of the day](img/day04.png)

---

## A suggested approach

### If you need a starting point

**Step 1 – Start from the tests**
- What is the main behaviour under test?
- How would you explain this exercise in one or two sentences to another dev?

**Step 2 - The implementation with reviewer eyes**
- Phrase your thoughts as real review comments:
  - Questions → “What would you think of…?”, “Why this choice?”
  - Suggestions → “Maybe extract…”, “Consider renaming…”
  - Praise → “I like how…”, “Nice use of…”

**Step 3 - Review yourself**
- Review your own comments
  - Did I put enough information? Too much?
  - What is my posture?
  - Who I like receiving this feedback?

### Capture your journey

In `journey/your-name.md`, add a short entry for today:

- One sentence describing the **behaviour** you saw in the tests.
- 2–3 review comments you’re **proud** of (questions, suggestions, praise).
- 1 thing you’ve noticed about **your own review posture** (do you nitpick, praise, redesign, etc.?).

