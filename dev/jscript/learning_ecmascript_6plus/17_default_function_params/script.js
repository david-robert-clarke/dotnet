let add = function sum(x = 5, y = 3) {
    console.log(x + y);
}

add(1, 3);

function haveFun(activityName = "hiking", time = 5) {
    console.log(`Today I will go ${activityName} for ${time} hours`);
}

haveFun("Walk", 5);
haveFun("Rambling");