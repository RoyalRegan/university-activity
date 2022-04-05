#include "Change_PIN.h"

using namespace System;
using namespace System::Windows::Forms;
[STAThreadAttribute]
void Main6(array<String^>^ args)
{
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false);
	Курсач::Change_PIN form;
	Application::Run(%form);
}