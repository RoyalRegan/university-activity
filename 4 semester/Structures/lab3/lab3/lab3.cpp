

#include "pch.h"
#include <iostream>
#include <vector>
#include <queue>

#define Len 6

using namespace std;


void Warshall(int d[][Len], int a[][Len], int n) {
	int i, j, k;
	for (i = 0; i <= n - 1; i++)
		for (j = 0; j <= n - 1; j++)
			if (i == j)
				d[i][j] = 1;
			else
				if (a[i][j] == 0)
					d[i][j] = 0;
				else
					d[i][j] = 1;
	for (k = 0; k <= n - 1; k++)
		for (i = 0; i <= n - 1; i++)
			for (j = 0; j <= n - 1; j++)
				if (d[i][j] == 0)
					if (d[k][j] == 1 && d[i][k] == 1)
						d[i][j] = 1;
}


int main()
{
	int graph[Len][Len] = {
	{0,7,9,0,0,0},
	{0,0,0,0,0,0},
	{0,10,0,0,0,2},
	{0,15,11,0,6,0},
	{0,0,0,0,0,0},
	{14,0,0,0,9,0}
	};
	int worshel[Len][Len];

	Warshall(worshel, graph, Len);

	for (int i = 0; i < Len; i++) {
		for (int j = 0; j < Len; j++) {
			cout << graph[i][j] << " ";
		}
		cout << endl;
	}
	cout << "Worshel" << endl;

	for (int i = 0; i < Len; i++) {
		for (int j = 0; j < Len; j++) {
			cout << worshel[i][j] << " ";
		}
		cout << endl;
	}

	vector <int> was(Len, -1);
	queue <int> q;
	int cur = 1;
	for (int i = 0; i < Len; i++)
	{
		if (was[i] != -1)
			continue;
		q.push(i);
		while (!q.empty())
		{
			int v = q.front();
			q.pop();
			if (was[v] != -1)
				continue;
			was[v] = cur;
			for (int j = 0; j < Len; j++)
				if (graph[i][j] != 0 && was[j] == -1)
					q.push(j);
		}
		cur++;
	}
	cout << "///" << endl;
	int b= 1;
	for (int a : was) {
		cout << b << " : " << a << endl;
		b++;
	}
	system("pause");
}

