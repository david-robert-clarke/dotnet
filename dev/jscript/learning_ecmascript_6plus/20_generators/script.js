function* director() {
    yield "Three";
    yield "Two";
    yield "One";
    yield "Action";
}

let countDown = director();

console.log(countDown.next().value);
console.log(countDown.next().value);
console.log(countDown.next().value);
console.log(countDown.next());
console.log(countDown.next());
console.log(countDown.next());