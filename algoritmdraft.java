solve(int x, int y){
	if(kolla så att vi är i sudokut){
		if(arr[x][y] != 0){
			if((++x) > 8){
				x = 0;
				if((++y) > 8){
					this.verify;
				}
			}
		} else if {
			for(n = 1; n < 10; n++){
				if(check(x, y, n){
					arr[x][y] = n;
					solve(++x, y);
				}
			}
		}
	}
}


private void solve(int x, int y){
	if(x > 8){
		x = 0;
		++y;
		if(y > 8){
			finalize;
		} else {
			solve(x, y);
		}
	} else if(arr[x][y] != 0){
			solve(++x, y);
	} else {
		for(n = 1; n < 10; n++){
			if(check(x, y, n){
				arr[x][y] = n;
				solve(++x, y);
			}
		}
		arr[x][y] = 0;		
	}
	return;
}

//kommentar tillagd av love