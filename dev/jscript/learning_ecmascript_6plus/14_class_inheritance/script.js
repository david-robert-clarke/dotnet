class Vehicle {
    constructor(description, wheels) {
        this.description = description;
        this.wheels = wheels;
    }

    describeYourself() {
        console.log(`I am a ${this.description} with ${this.wheels} wheels.`)
    }
}

class Van extends Vehicle {
    constructor() {
        super("Van", 6);
    }
}

let iceCreamVan = new Van();
iceCreamVan.describeYourself();