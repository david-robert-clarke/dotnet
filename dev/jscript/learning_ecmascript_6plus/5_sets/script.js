let books = new Set();
books.add("pride and predjudice").add("war and peace").add("war and peace").add("Oliver Twist");

console.log(books);
console.log(books.size);

books.delete("Oliver Twist");
books.forEach(function (item) {
    console.log(item);
})

console.log(books);

console.log("has David Twist", books.has("David Twist"));