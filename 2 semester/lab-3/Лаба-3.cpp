#include "stdafx.h"
#include <iostream>	
#include <string>
#include <math.h>
#include "locale.h"
using namespace std;

void StrVvod(char *&S, int &N); // ввод строки
bool Podstr(char *S, int N, char *S1, int N1);// задание 1 
bool Proverka(string S);// проверка для задания 2
unsigned long long Perevod(string S);// перевод для задания 2
void SumStr(string S1, string S2, string &S);// задание 2

int main()
{
	setlocale(LC_ALL, "RUS");
	int vbr = 3;
	char *S = new char[0];
	char *S1 = new char[0];
	string s1;
	string s2;
	string s;
	int N = 0;
	int N1 = 0;
	while (vbr != 0)
	{
		system("cls");
		cout << "Лаба-3" << endl;
		cout << "ИКБО-07-17 Ануфриев В.В" << endl;
		cout << "Меню" << endl;
		cout << "1) Задание 1" << endl;
		cout << "2) Задание 2" << endl;
		cout << "0) Выход" << endl;
		cout << "Ваш выбор: ";
		cin >> vbr;
		cin.get();
		system("cls");
		switch (vbr)
		{
		case 1:
		{
			cout << "Заполните строку" << endl;
			StrVvod(S, N);
			cout << "Заполните подстроку" << endl;
			StrVvod(S1, N1);
			cout << endl;
			if (Podstr(S, N, S1, N1))
			{
				cout << "Подстрока входит в строку " << endl;
			}
			else
			{
				cout << "Подстрока не входит в строку" << endl;
			}
			N = 0;
			N1 = 0;
			system("pause");
			break;
		}
		case 2:
		{
			cout << "Заполните строку 1" << endl;
			cin >> s1;
			while (!Proverka(s1))
			{
				cout << "Введите строку длинной больше 10 только из чисел" << endl;
				cin >> s1;
			}
			cout << "Заполните строку 2" << endl;
			cin >> s2;
			while (!Proverka(s2))
			{
				cout << "Введите строку длинной больше 10 только из чисел" << endl;
				cin >> s2;
			}
			cout << endl;
			cout << "Сумма строк: ";
			SumStr(s1, s2, s);
			cout << s << endl;
			system("pause");
			break;
		}
		default:
			break;
		}
	}
	system("pause");
	return 0;
}

void StrVvod(char *&S, int &N) // ввод строки
{
	char s;
	for (int i = 0; cin.get(s) && s != '\n'; i++)
	{
		N++;
		S = (char*)realloc(S, N * sizeof(char));
		S[i] = s;
	}
	S[N] = '\0';
}

bool Podstr(char *S, int N, char *S1, int N1) // задание 1 
{
	int count = 0;
	int j = 0;
	for (int i = 0; i < N; i++)
	{
		if (S[i] == S1[j])
		{
			count++;
			if (j < N1)
			{
				j++;
			}
			if (count == N1)
			{
				return true;
			}
		}
		else
		{
			j = 0;
			i = i - count;
			count = 0;
		}
	}
	return false;
}

bool Proverka(string S) // проверка для задания 2
{
	int N = S.length();
	if (N > 10)
	{
		bool ok = false;
		for (int i = 0; i < N; i++)
		{
			if (S[i] >= '0'&& S[i] <= '9')
			{
				ok = true;
			}
			else
			{
				ok = false;
			}
		}
		if (ok)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	else
	{
		return false;
	}
}

unsigned long long Perevod(string S) // перевод для задания 2
{
	unsigned long long sum = 0;
	int N = S.length();
	for (int i = 0; i < N; i++)
	{
		sum += ((int)S[i] - 48)*(unsigned long long)pow(10, N - i - 1);
	}
	return sum;
}

void SumStr(string S1, string S2, string &S) // задание 2
{
	unsigned long long sum;
	unsigned long long k;
	char g[2];
	int l;
	int count = 0;
	sum = Perevod(S1) + Perevod(S2);
	k = sum;
	while (k != 0)
	{
		count++;
		k /= 10;
	}
	char mas[20];
	for (int i = count - 1; i>-1; i--)
	{
		l = sum % 10;
		sum /= 10;
		_itoa_s(l, g, 10);
		mas[i] = g[0];
	}
	mas[count] = '\0';
	S = mas;
}