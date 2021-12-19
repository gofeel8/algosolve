function solution(numbers) {
    const length = numbers.length;
    const isPrime = Array(Math.pow(10,length)).fill(true);
    isPrime[0]=false;
    isPrime[1]=false;
    for(let i=2;i<=Math.ceil(Math.sqrt(Math.pow(10,length)));i++){
        if(!isPrime[i])continue;
        for(let j=2;j*i<Math.pow(10,length);j++){
            isPrime[j*i]=false;
        }
    }
    const numberArr = Array.from(numbers);
    const used = Array.from(numberArr,()=>false);
    const answer =0;
    const set = new Set();
    for(let i=1;i<=length;i++){
        perm(numberArr,used,0,0,isPrime,0,i,set);
    }
    return set.size;
}

function perm(numberArr,used,idx,now,isPrime,cnt,ea,set){
    if(idx==ea || idx==numberArr.length){
        if(isPrime[now])set.add(now);
        return;
    }
    for(let i=0;i<numberArr.length;i++){
        if(used[i])continue;
        cnt = perm(numberArr,used,idx+1,now,isPrime,cnt,ea,set);
        used[i]=true;
        cnt = perm(numberArr,used,idx+1,Number(now*10)+Number(numberArr[i]),isPrime,cnt,ea+1,set);
        used[i]=false;
    }
    return;
}
