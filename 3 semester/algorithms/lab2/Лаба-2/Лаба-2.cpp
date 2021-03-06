// Лаба-2.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <string>

using namespace std;


bool find_dog(string mail)
{
	int count = 0;
	for (int i = 0; i < mail.length(); i++)
	{
		if (mail[i] == '@')
		{
			count++;
		}
	}
	if (count > 1)
	{
		return true;
	}
	else
	{
		return false;
	}
}

bool mail_check(string mail)
{
	int count = 0;
	int dog_index = -1;
	for (int i = 0; i < mail.length(); i++)
	{
		if (isalpha(mail[i]) || isdigit(mail[i]) || mail[i] == '-' || mail[i] == '_' || mail[i] == '.' || mail[i] == '@')
		{
			if (i == 0 && (mail[i] == '-' || mail[i] == '_' || mail[i] == '.' || mail[i] == '@'))
			{
				return false;
			}
			if ((mail[i] == '-' || mail[i] == '_' || mail[i] == '.' || mail[i] == '@') && !isalpha(mail[i - 1]) && !isdigit(mail[i - 1]))
			{
				return false;
			}
			if (mail[i] == '@')
			{
				if (!find_dog(mail))
				{
					dog_index = i;
				}
				else
				{
					return false;
				}
			}
			if (dog_index > 0 && i > dog_index)
			{
				if (mail[i] == '_')
				{
					return false;
				}
			}
			if (i == mail.length() - 1 && (mail[i] == '-' || mail[i] == '.'))
			{
				return false;
			}
			if (i == mail.length()-1)
			{
				for (int j = dog_index; j < mail.length(); j++)
				{
					if (mail[j] == '.')
					{
						return true;
					}
				}
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	return true;

}

int main()
{
	setlocale(LC_ALL, "RUS");
	string mail;
	cout << "Введите для проверки адрес: "; getline(cin, mail);
	if (!mail_check(mail))
	{
		cout << "Введенный адрес не корректный " << endl;
	}
	else
	{
		cout << "Введенный адрес корректный" << endl;
	}
	system("pause");
    return 0;
}

