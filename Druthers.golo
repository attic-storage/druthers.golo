module Druthers

import java.lang.Math
import java.lang.Thread
import AnsiStringAugmentations

let comparator = (|o1, o2| {
  println("What do you prefer between these? (hit 'enter' if this choice is not possible)": inGreen())
  println("   Druther 1 : ": inCyan(): append(o1))
  println("   Druther 2 : ": inPurple(): append(o2))
  var result = 0
  let choice = readln("Make your choice 1 or 2 > ": inGreen())
  if (choice == "1") {
    result = -1
  } else if (choice == "2") {
    result = 1
  }
  return result
}): to(java.util.Comparator.class)

function intro = {
    println("Hey lazy,": inRed())
    Thread.sleep(1000_L)
    println("Give me your druthers that I can sort them ? Please (quit to ... quit)": inRed())
}

function druthers = {
  var mydruthers = list[]
  var mydruther = readln("> ": inYellow())
  while("quit" != mydruther) {
      mydruthers: append(mydruther: trim())
      mydruther = readln("> ": inYellow())
  }
  return mydruthers
}

function sortProcess = |mydruthers| {
  print("Thanks lazy, I can start to sort ": inRed())
  range(0, mydruthers: size()): each(|e| -> {
    print("..": inRed())
    Thread.sleep(1000_L)
  })
  println(".. with you\n": inGreen())
  Thread.sleep(1000_L)
  return mydruthers: ordered(comparator)
}

function printResult = |mySortedDruthers| {
  if(mySortedDruthers: size() > 2) {
    let boringSince = round(random() * mySortedDruthers: size()): intValue() - 1
    println("It's about time, I'm bored since ": append(boringSince): append(" comparisons"): inPurple())
    Thread.sleep(2000_L)
  }
  println("Your preferred druthers": inGreen())
  mySortedDruthers: each(|e| -> println("    ": append(e): inCyan()))
  println("Good bye, see you soon with better druthers, pleeeeeeeease for my sanity!!!": inRed())
}

function main = |args| {
  intro()
  let myDruthers = druthers()
  let mySortedDruthers = sortProcess(myDruthers)
  printResult(mySortedDruthers)
}
