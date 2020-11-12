var ans = "";
var height = prompt("enter the height of the Christmas Tree: ");

for(let i=1; i<height; i++){
    ans = "";
    for(let j=i; j<name; j++){
        ans += " ";
    }
    if(i==1){
        ans += "*";
    }
    else{
        for(let k=0; k<(i*2)-1; k++){
            ans += "0";
        }
    }
    console.log(ans);
}