#include "Registration.h"

using namespace System;
using namespace System::Windows::Forms;
[STAThreadAttribute]
void Main5(array<String^>^ args)
{
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false);
	������::Registration form;
	Application::Run(%form);
}