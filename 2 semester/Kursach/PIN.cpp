#include "PIN.h"

using namespace System;
using namespace System::Windows::Forms;
[STAThreadAttribute]
void Main7(array<String^>^ args)
{
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false);
	������::PIN form;
	Application::Run(%form);
}