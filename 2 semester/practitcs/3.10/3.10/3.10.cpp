// 3.10.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

int main()
{
	setlocale(LC_ALL,("RUS"));
	bool A = false, B = false, C = true;
	cout << "а) "<< ((!A || !B) && !C) << endl;
	cout << "б) " << ((!A || !B) && (A || B)) << endl;
	cout << "в) " << (A && B || A && C || !C) << endl;
	system("pause");
    return 0;
}

