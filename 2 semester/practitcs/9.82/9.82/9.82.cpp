// 9.82.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include<iostream>
#include <string>
#include <Windows.h>
using namespace std;

bool check(string s)
{
	int count = 0;
	for (auto x : s)
	{
		if (x != ' ')
		{
			count++;
		}
		if (x == '-')
		{
			return true;
		}
	}
	if (count > 0)
	{
		return false;
	}
	return true;
}

string first_word(string s)
{
	string sup;
	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] != ' ')
		{
			for (int j = i; j < s.length(); j++)
			{
				if (s[j] != ' ')
				{
					sup += s[j];
				}
				else
				{
					break;
				}
			}
			break;
		}
	}
	return sup;
}

int main()
{
	SetConsoleCP(1251);
	SetConsoleOutputCP(1251);
	string words;
	int count = 0;
	cout << "Введите предложение без символа -" << endl; getline(cin, words);
	while (check(words))
	{
		cout << "Строка не должна содержать - и в ней обязан быть хотя бы один символ отличный от пробела" << endl;
		getline(cin, words);
	}
	for (auto x : first_word(words))
	{
		if (x == 'o' || x == 'о')
		{
			count++;
		}
	}
	cout << "Количество букв o в первом слове: " <<count<< endl;
	system("pause");
    return 0;
}

