let yell = "mooooooo";

let party = yell.repeat(20);

console.log(party);

let cat = {
    meow(times) {
        console.log("Meow".repeat(times));
    },
    purr(times) {
        console.log("Purr".repeat(times));
    }
}

cat.meow(10);
cat.purr(50);