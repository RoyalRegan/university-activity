#include "Main.h"

using namespace System;
using namespace System::Windows::Forms;
[STAThreadAttribute]
void Main2(array<String^>^ args)
{
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false);
	Курсач::Main form;
	Application::Run(%form);
}