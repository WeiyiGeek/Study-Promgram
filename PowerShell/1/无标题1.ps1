if(Get-Module -Name Posh-SSH){
  Write-Host "# Posh-SSH 模块已安装"  -ForegroundColor Green
}else{
  Write-Host "# Posh-SSH 模块未安装,正在安装该模块，注意需要管理员权限!"  -ForegroundColor red
  Install-Module -Force SSHSessions
}