function solution(n, times) {
    var answer = Number.MAX_VALUE;
    times.sort((a,b)=>a-b);
    let left = 1;
    let right = n*times[times.length-1];
    while(left<=right){
        const mid = Math.floor((left+right)/2);
        let cnt =0;
        for(let i=0;i<times.length;i++){
            cnt+= Math.floor(mid/times[i]);
        }
        if(cnt>=n){
            answer = Math.min(mid,answer);
            right = mid-1;
        }else{
            left = mid+1;
        }
    }
    return answer;
}
