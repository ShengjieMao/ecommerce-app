let sportsOne: string[] = ["Golf", "Tennis", "Swimming"];

/*
for (let i=0; i < sportsOne.length; i++){
    console.log(sportsOne[i]);
}
*/

// simplified for loop:
for (let tempSport of sportsOne){
    if (tempSport = "Swimming"){
        console.log(tempSport + "<< my favourite!");
    }
    else{
        console.log(tempSport);
    }
}
