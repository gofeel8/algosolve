function solution(maps) {
    var answer = 0;
    const dr = [-1,0,1,0];
    const dc = [0,1,0,-1];
    const visited = Array.from({length:maps.length},(v,i)=>Array(maps[0].length).fill(false));
    visited[0][0]=true;
    const queue = [[0,0]];
    let cnt =0;
    let find = false;
    while(queue.length!==0){
        cnt++;
        const size = queue.length;
        for(let i=0;i<size;i++){
            const now = queue.shift();
            for(let j=0;j<4;j++){
                if([now[0]+dr[j]]<0 || [now[0]+dr[j]]==maps.length ||[now[1]+dc[j]]<0 || [now[1]+dc[j]]==maps[0].length)continue;
                if(maps[now[0]+dr[j]][now[1]+dc[j]]==0)continue;
                if(visited[now[0]+dr[j]][now[1]+dc[j]]==false){
                    if([now[0]+dr[j]]==maps.length-1 && [now[1]+dc[j]]==maps[0].length-1){
                       find = true;
                        cnt++;
                        return cnt;
                    }
                    visited[now[0]+dr[j]][now[1]+dc[j]]=true;
                    queue.push([(now[0]+dr[j]),(now[1]+dc[j])]); 
                }
            }
        }
        
    }
    return -1;
}
