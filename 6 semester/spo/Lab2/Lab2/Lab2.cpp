#include <iostream>
#include <windows.h>
#pragma warning(disable: 4996)

using namespace std;

int main()
{
	setlocale(LC_ALL, "Russian");

	char bufferComputerName[256];
	DWORD bufferSize = 256;

	GetComputerNameA(bufferComputerName, &bufferSize);
	cout << "Имя компьютера: ";
	printf("%s\n", bufferComputerName);

	char bufferUserName[256];
	GetUserNameA(bufferUserName, &bufferSize);
	cout << "Имя пользователя: ";
	printf("%s\n", bufferUserName);

	char bufferSystemDir[256];

	GetSystemDirectoryA(bufferSystemDir, bufferSize);
	cout << "Системная директория: ";
	printf("%s\n", bufferSystemDir);

	_OSVERSIONINFOA os;
	os.dwOSVersionInfoSize = sizeof(os);
	GetVersionExA(&os);
	cout << "Версия операционной системы: " << os.dwMajorVersion << "." << os.dwMinorVersion << endl;

	cout << "Системные метрики " << endl;
	cout << "1. Высота курсора в пикселях " << GetSystemMetrics(14) << endl;
	cout << "2. Тип старта системы " << GetSystemMetrics(67) << endl;

	cout << SystemParametersInfoA(SPI_GETBORDER, 0, 0, 0);


	system("pause");
}

