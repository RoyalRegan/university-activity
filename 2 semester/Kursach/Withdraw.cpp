#include "Withdraw.h"

using namespace System;
using namespace System::Windows::Forms;
[STAThreadAttribute]
void Main9(array<String^>^ args)
{
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false);
	Курсач::Withdraw form;
	Application::Run(%form);
}