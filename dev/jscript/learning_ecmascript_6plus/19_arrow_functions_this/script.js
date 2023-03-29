let person = {
    first: "David",
    hobbies: ["walk", "dance", "sleep"],
    printHobbies: function () {
        this.hobbies.forEach((hobby) => {
            let string = `${this.first} like to ${hobby}`;
            console.log(string)
        })
    }
}

person.printHobbies();