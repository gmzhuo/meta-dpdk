include dpdk.inc

CONFIG_NAME = "common_linux"
TEST_DIR = "app/test"

STABLE = "master"
BRANCH = "master"
SRCREV = "d7142fbae16f185e11bfa44be061399afc40a1be"

SRC_URI = "git://github.com/DPDK/dpdk;branch=${STABLE} \
                file://dpdk-16.04-add-RTE_KERNELDIR_OUT-to-split-kernel-bu.patch \
                file://dpdk-16.07-add-sysroot-option-within-app-makefile.patch \
          "

LICENSE = "BSD-3-Clause & LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://license/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://license/lgpl-2.1.txt;md5=4b54a1fd55a448865a0b32d41598759d \
                    file://license/bsd-3-clause.txt;md5=0f00d99239d922ffd13cabef83b33444"

do_install:append () {
    # Remove the unneeded dir
    rm -rf ${D}/${INSTALL_PATH}/${RTE_TARGET}/app
}
