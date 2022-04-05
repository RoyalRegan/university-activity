#include"stdafx.h"
#include"Binare_operations.h"
#include <iostream>
#include <fstream>
#include <ctime>

void create_bin_file(ifstream &read, ofstream &write)
{
	read.open("Information.txt", ios::out);
	write.open("Info_binar.txt", ios::out | ios::binary);
	bill account;
	while (!read.eof())
	{
		read >> account.bill_number;
		read.get();
		getline(read, account.fio.SecondName);
		getline(read, account.fio.FirstName);
		getline(read, account.fio.Patronymic);
		getline(read, account.adress.City);
		getline(read, account.adress.Street);
		read >> account.adress.House;
		read.get();
		read >> account.adress.Apartament;
		read.get();
		write.write((char*)&account, sizeof(bill));
		account.key++;
	}
	read.close();
	write.close();
}

void show_bin_file(ifstream &read)
{
	bill account;
	read.open("Info_binar.txt", ios::in | ios::binary);
	read.read((char*)&account, sizeof(bill));
	while(!read.eof())
	{
		cout << endl;
		cout << account.bill_number<<endl;
		cout << account.fio.SecondName << endl;
		cout << account.fio.FirstName << endl;
		cout << account.fio.Patronymic << endl;
		cout << account.adress.City << endl;
		cout << account.adress.Street << endl;
		cout << account.adress.House << endl;
		cout << account.adress.Apartament << endl;
		cout << endl;
		read.read((char*)&account, sizeof(bill));
	}
	read.close();
}

void search_key(ifstream &read,int k)
{
	bill account;
	read.open("Info_binar.txt", ios::in | ios::binary);
	read.read((char*)&account, sizeof(bill));
	while (!read.eof())
	{
		if (account.key == k)
		{
			cout << "������ �� �����: " << k << endl;
			cout << account.bill_number << endl;
			cout << account.fio.SecondName << endl;
			cout << account.fio.FirstName << endl;
			cout << account.fio.Patronymic << endl;
			cout << account.adress.City << endl;
			cout << account.adress.Street << endl;
			cout << account.adress.House << endl;
			cout << account.adress.Apartament << endl;
		}
		read.read((char*)&account, sizeof(bill));
	}
	read.close();
}

void refresh(ifstream &read, ofstream &write, int k)
{
	bill account;
	read.open("Info_binar.txt", ios::in | ios::binary);
	read.read((char*)&account, sizeof(bill));
	write.open("Info_binar.txt", ios::in | ios::binary);
	while (!read.eof())
	{
		if (account.key == k)
		{
			int num;
			cout << "������� ����� ���� ������� ������ ��������" << endl;
			cout << "1.�����" << endl;
			cout << "2.�������" << endl;
			cout << "3.���" << endl;
			cout << "4.��������" << endl;
			cout << "5.�����" << endl;
			cout << "6.�����" << endl;
			cout << "7.���" << endl;
			cout << "8.��������" << endl;
			cout << "������� ����� ����: ";
			cin >> num;
			cin.get();
			switch (num)
			{
			case 1:
			{
				cin >> account.bill_number;
				write.write((char*)&account, sizeof(bill));
				break;
			}
			case 2:
			{
				getline(cin, account.fio.SecondName);
				write.write((char*)&account, sizeof(bill));
				break;
			}
			case 3:
			{
				getline(cin, account.fio.FirstName);
				write.write((char*)&account, sizeof(bill));
				break;
			}
			case 4:
			{
				getline(cin, account.fio.Patronymic);
				write.write((char*)&account, sizeof(bill));
				break;
			}
			case 5:
			{
				getline(cin, account.adress.City);
				write.write((char*)&account, sizeof(bill));
				break;
			}
			case 6:
			{
				getline(cin, account.adress.Street);
				write.write((char*)&account, sizeof(bill));
				break;
			}
			case 7:
			{
				cin >> account.adress.House;
				write.write((char*)&account, sizeof(bill));
				break;
			}
			case 8:
			{
				cin >> account.adress.Apartament;
				write.write((char*)&account, sizeof(bill));
				break;
			}
			default:
				break;
			}
		}
		else
		{
			write.write((char*)&account, sizeof(bill));
		}
		read.read((char*)&account, sizeof(bill));
	}
	read.close();
	write.close();
}