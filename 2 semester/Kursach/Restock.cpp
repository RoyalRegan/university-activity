#include "Restock.h"

using namespace System;
using namespace System::Windows::Forms;
[STAThreadAttribute]
void Main8(array<String^>^ args)
{
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false);
	Курсач::Restock form;
	Application::Run(%form);
}