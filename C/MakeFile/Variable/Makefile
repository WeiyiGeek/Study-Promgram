ifdef DEFINE_VAL
	VRE = "Hello World,Define!"
	else
	endif
ifeq ($(OPT),define)
	VRE := "Define fugai"
	else
	endif
ifeq ($(OPT),add)
	VRE += "Add Define"
	else
	endif
ifeq ($(OPT),recover)
	VRE ?= "New Hello World!!"
	else
	endif
all:
	@echo $(VRE)
