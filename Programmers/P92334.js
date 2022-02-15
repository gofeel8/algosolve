function solution(id_list, report, k) {
    const setObj ={};
    const answer = new Array(id_list.length).fill(0);
    const idxObj = {};
    id_list.forEach((id,idx)=>{
        setObj[id]= new Set();
        idxObj[id]=idx;
    });
    
    report.forEach((item,idx)=>{
        const splited =item.split(/\s/); 
        setObj[splited[1]].add(splited[0]);
    })
    
    for(let i in setObj){
        if(setObj[i].size>=k){
            for(let k of setObj[i]){
                answer[idxObj[k]]++;
            }
        }
    }
    
    return answer;
}
