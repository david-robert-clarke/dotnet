class Hike {
    constructor(distance, pace) {
        this.distance = distance;
        this.pace = pace;
    }
    get lengthInHours() {
        return `${this.calcLength()} hours`;
    }
    calcLength() {
        return this.distance / this.pace
    }
}

const mtBelvidiers = new Hike(10, 3);

console.log(mtBelvidiers.lengthInHours);