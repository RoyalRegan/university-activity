// Лаба-1(2).cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include "malloc.h"
#include "locale.h"
#include <math.h>
#include "time.h"

using namespace std;
void MasVvod(int* a,int n); //ввода массива(с клавиатуры)
void rand(int* a, int n); //ввода массива(рандомными числами)
void MasVivod(int* a,int n); //вывод массива
double SredArf(int* a, int n); //задание 1
int ChiselBol3(int* a, int n); //кол-во чисел которые в двоичном коде содержат больше 3-ех едениц 
void NewMas(int* a, int n, int* b, int k); //задание 2
bool simple(int element); // проверка простое ли число 
void Upor(int*a, int n,int* b); //задание 3
void Delet(int* &a, int &n); //задание 4

int main()
{
	setlocale(LC_ALL, "RUS");
	srand(time(NULL));
	int *A=0;
	int *B=0;
	int N;
	int K;
	int k;
	bool ok = false;
	int vbr = 10;


	while (vbr != 0)
	{
		system("cls");
		cout << "Задание 2" << endl;
		cout << "ИКБО-07-17 Ануфриев В.В" << endl;
		cout << "Меню"<< endl;
		cout << "1) Заполнить массив(руч)" << endl;
		cout << "2) Заполнить массив(авто)" << endl;
		cout << "3) Вывести массив\n";
		cout << "4) Найти среднее арифметическое значение элементов, расположенных между первым\nнаибольшим и первым наименьшим элементами, включая эти элементы" << endl;
		cout << "5) Сформировать массив В, из тех элементов массива А, у которых двоичный код\nсодержит более трех единиц" << endl;
		cout << "6) Выполнить упорядочение массива А по правилу: с младших индексов разместить\nэлементы большие нуля, затем меньшие нуля, затем нули" << endl;
		cout << "7) Удалить все элементы массива, являющиеся простыми числами" << endl;
		cout << "Ваш выбор: ";
		cin >> vbr;
		system("cls");
		switch (vbr)
		{
		case 1:
		{
			cout << "Введите кол-во элементов в массиве: ";
			cin >> N;
			if (N > 0)
			{
				A = new int[N];
				cout << "Введите элементы массива: " << endl;
				MasVvod(A, N);
				ok = true;
			}
			else
			{
				cout << "Кол-во элементов массива должно быть больше 0" << endl;
			}
			system("pause");
			break;
		}
		case 2:
		{
			cout << "Введите кол-во элементов в массиве: ";
			cin >> N;
			if (N > 0)
			{
				A = new int[N];
				rand(A, N);
				ok = true;
			}
			else
			{
				cout << "Кол-во элементов массива должно быть больше 0" << endl;
			}
			system("pause");
			break;
		}
		case 3:
		{ 
			if (ok == true)
			{
			cout << "Вывод массива\n";
			MasVivod(A, N);
			}
			else
			{
				cout << "Введите массив" << endl;
			}
			system("pause");
			break;
		}
		case 4:
		{  
			if (ok == true)
			{
				cout << "Среднее"<<endl << SredArf(A, N) << endl;
				
			}
			else
			{
				cout << "Введите массив" << endl;
			}
			system("pause");
			break;
		}
		case 5:
		{   
			if (ok == true)
			{
				cout << "Массив с числами в 2-ой системе которые содержать больее 3-ех едениц" << endl;
				k = ChiselBol3(A, N);
				K = k;
				B = new int[K];
				NewMas(A, N, B, K);
			}
			else
			{
				cout << "Введите массив" << endl;
			}
			system("pause");
			break;
		}
		case 6:
		{
			if (ok == true)
			{
				cout << "упорядоченный массив" << endl;
				B = new int[N];
				Upor(A, N, B);
			}
			else
			{
				cout << "Введите массив" << endl;
			}
			system("pause");
			break;
		}
		case 7:
		{
			if (ok == true)
			{
				Delet(A, N);
				MasVivod(A, N+1);
			}
			else
			{
				cout << "Введите массив" << endl;
			}
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

void MasVvod(int* a,int n) //ввода массива(с клавиатуры)
{
	int q;
	for (int i=0;i<n;i++)
	{
		cin >> q;
		for (int j = 0;j < n;j++)
		{
			if (j != i)
			{
				if (q != a[j])
				{
					a[i] = q;
				}
				else
				{
					cout << "Введите ранее не использованный элемент"<<endl;
					cin >> q;
					j--;
				}
			}
			else
			{
				a[i] = q;
			}
		}
		
	}
}

void rand(int* a, int n) //ввода массива(рандомными числами)
{
	srand((unsigned)time(NULL));
	for (int i = 0;i < n;i++)
	{
		a[i] = (int)rand();
	}
	bool mas = true;
}

void MasVivod(int* a, int n) //вывод массива
{
	for (int i = 0; i < n; i++)
	{
		cout << a[i] << " ";
	}
	cout << endl;
}

double SredArf(int* a, int n) //задание 1
{
	int min = 2147483647;
	int max = -2147483647;
	int con1=0;
	int con2=0;
	int count = 0;
	double sred = 0;
	int q;

	for (int i = 0; i < n;i++)
	{
		if (a[i] < min)
		{
			min = a[i];
			con1 = i;
		}
		if (a[i] > max)
		{
			max = a[i];
			con2 = i;
		}
	}
	if (con1 > con2)
	{
		q = con2;
		con2 = con1;
		con1 = q;
	}
	for (int i = con1;i < con2+1;i++)
	{
		sred += a[i];
		count++;
	}
	sred = sred /count;
	return sred;
}

int ChiselBol3(int* a, int n) //кол-во чисел которые в двоичном коде содержат больше 3-ех едениц 
{
	int q,c;
	int k = 0;
	int count = 0;
	for (int i = 0; i < n; i++)
	{
		q = abs(a[i]);
		c = q;
		while (c != 0)
		{
			q = c % 2;
			if (q == 1)
			{
				count++;
				if (count >3)
				{
					count = 0;
					k++;
				}
			}
			c = c / 2;
			if (c == 0)
			{
				count = 0;
			}
		}
	}
	return k;
}

void NewMas(int* a, int n, int* b, int k) // задание 2
{
	int q,c;
	int count = 0;
	for (int i = 0;i < k;)
	{
		for (int j = 0;j < n;j++)
		{
			q = abs(a[j]);
			c = q;
			while (c != 0)
			{
				q = c % 2;
				if (q == 1)
				{
					count++;
					if (count > 3)
					{
						b[i] = a[j];
						count = 0;
						i++;
					}
				}
				c = c / 2;
				if (c == 0)
				{
					count = 0;
				}
			}
		}
	}
	for (int i = 0; i < k; i++)
	{
		cout << b[i] << " ";
	}
	cout << endl;
}

bool simple(int element) // проверка простое ли число 
{
	if (element == 0 || element == 1)
	{
		return false;
	}
	else if (element == 2)
	{
		return true;
	}
	else
	{
		int calc = 0;
		for (int i = 2; i <= element / 2; i++)
		{
			if (!(element % i))
			{
				calc++;
			}
		}
		if (calc >= 1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}

void Upor(int*a, int n, int* b) //задание 3
{
	int c=0;
	for (int i = 0;i < n;i++)
	{
		if (a[i] > 0)
		{
			b[c] = a[i];
			c++;
		}
	}
	for (int i = 0;i < n;i++)
	{
		if (a[i] < 0)
		{
			b[c] = a[i];
			c++;
		}
	}
	for (int i = 0;i < n;i++)
	{
		for (int j = i;j < n;j++)
		{
			if (a[i] == 0)
			{
				b[c] = a[i];
				c++;
			}
		}
	}
	for (int i = 0;i < n;i++)
	{
		cout << b[i] << " ";
	}
	cout << endl;
}

void Delet(int* &a, int &n) //задание 4
{
	bool d;
	for (int i = 0;i < n;i++)
	{
		d = (simple(a[i]));
		if (d == true)
		{
			for (int j = i;j < n;j++)
			{ 
				a[j] = a[j + 1];
			}
			n--;
		}
	}
	a = (int*)realloc(a, n * sizeof(int));
}

