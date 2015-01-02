# Project Euler

[Project Euler](https://projecteuler.net) has the following to say about its own purpose:

> Project Euler exists to encourage, challenge, and develop the skills and enjoyment of anyone with an interest in the fascinating world of mathematics.

You shouldn't really be reading the solutions of other people before having solved the problems on your own. This repository contains a regular plethora of spoilers.

## How to compute answers

**Note**:
This Clojure project makes use of [boot](http://boot-clj.com) which is assumed installed for the remainder of this README.

The following command (in bash, powershell, or the likes) will compute the answer to problem `i`:

```bash
boot run -n i
```

Just substitute an actual number for `i`, like

```bash
boot run -n 5
```

to print the smallest positive number that is evenly divisible by all of the numbers from 1 to 20, which is the challenge in problem 5.