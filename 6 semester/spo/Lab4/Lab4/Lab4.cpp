#include <stdio.h>
#include <errno.h>
#include <string>
#include <windows.h>

#define BUF_SIZE 256
#define UNICODE

#pragma warning(disable:4996)

using namespace::std;

void cLikeCopy() {
	const char* fileName1 = "test.txt";
	const char* fileName2 = "test2.txt";

	FILE* in_file, * out_file; char rec

		[BUF_SIZE]; size_t bytes_in,

		bytes_out;

	in_file = fopen(fileName1, "rb");

	if (in_file == NULL)
	{
		perror(fileName1);
		return;
	}

	out_file = fopen(fileName2, "wb");

	if (out_file == NULL)
	{
		perror(fileName2);
		return;
	}

	while ((bytes_in = fread(rec, 1, BUF_SIZE, in_file)) > 0)
	{
		bytes_out = fwrite(rec, 1, bytes_in, out_file);
		if (bytes_out != bytes_in)
		{
			perror("Неисправимая ошибка записи.");
			return;
		}
	}

	fclose(in_file);
	fclose(out_file);
}

void winApiCopy() {
	LPCWSTR  fileName1 = TEXT("test3.txt");
	LPCWSTR  fileName2 = TEXT("test4.txt");

	HANDLE hIn, hOut;
	DWORD nIn, nOut;
	CHAR Buffer[BUF_SIZE];


	hIn = CreateFile(fileName1, GENERIC_READ, 0, NULL,
		OPEN_EXISTING, 0, NULL);

	if (hIn == INVALID_HANDLE_VALUE)
	{
		printf("Нельзя открыть входной файл.Ошибка: % х\n",
			GetLastError());
		return;
	}

	hOut = CreateFile(fileName2, GENERIC_WRITE, 0, NULL,
		CREATE_ALWAYS, FILE_ATTRIBUTE_NORMAL,
		NULL);

	if (hOut == INVALID_HANDLE_VALUE)
	{
		printf("Нельзя открыть выходной файл.Ошибка: % х\n",
			GetLastError());
		return;
	}

	while (ReadFile(hIn, Buffer, BUF_SIZE, &nIn, NULL) && nIn > 0)
	{
		WriteFile(
			hOut, Buffer, nIn, &
			nOut, NULL);
		if (nIn != nOut)
		{
			printf("Неисправимая ошибка записи : % x\n", GetLastError());
			return;
		}
	}

	CloseHandle(hIn);
	CloseHandle(hOut);
}

void winApiCopyFileLike() {
	LPCWSTR  fileName1 = TEXT("test5.txt");
	LPCWSTR  fileName2 = TEXT("test6.txt");

	if (!CopyFile(fileName1, fileName2, FALSE))
	{
		printf("Ошибка CopyFile : % x\n", GetLastError());
		return;
	}
	return;
}

int main(int argc, char* argv[])
{
	cLikeCopy();
	winApiCopy();
	winApiCopyFileLike();
}
