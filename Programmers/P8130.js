function solution(s) {
    const obj ={
        "zero":0,
        "one":1,
        "two":2,
        "three":3,
        "four":4,
        "five":5,
        "six":6,
        "seven":7,
        "eight":8,
        "nine":9,
    }
    for(const alpha in obj){
        const regex = new RegExp(`${alpha}`,'g');
        s= s.replace(regex,obj[alpha]);   
    }
    return Number(s);
}
