const daytime = {
    breakfast: "porridge",
    lunch: "salad"
}

const nighttime = "falafel"

const backpackingMeals = {
    ...daytime,
    nighttime
};

console.log(backpackingMeals);