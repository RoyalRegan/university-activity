// 8.8.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

int main()
{
	for (int i = 1; i < 10; i++)
	{
		for (int j = 1; j < 10; j++)
		{
			cout.width(5);
			cout << j << " x " << i << " = " << i * j;
			if (i*j < 10)
			{
				cout << " ";
			}
		}
		cout << endl<<endl;
	}
	system("pause");
    return 0;
}

