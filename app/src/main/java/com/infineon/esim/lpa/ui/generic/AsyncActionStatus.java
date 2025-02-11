/*
 * THE SOURCE CODE AND ITS RELATED DOCUMENTATION IS PROVIDED "AS IS". INFINEON
 * TECHNOLOGIES MAKES NO OTHER WARRANTY OF ANY KIND,WHETHER EXPRESS,IMPLIED OR,
 * STATUTORY AND DISCLAIMS ANY AND ALL IMPLIED WARRANTIES OF MERCHANTABILITY,
 * SATISFACTORY QUALITY, NON INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE.
 *
 * THE SOURCE CODE AND DOCUMENTATION MAY INCLUDE ERRORS. INFINEON TECHNOLOGIES
 * RESERVES THE RIGHT TO INCORPORATE MODIFICATIONS TO THE SOURCE CODE IN LATER
 * REVISIONS OF IT, AND TO MAKE IMPROVEMENTS OR CHANGES IN THE DOCUMENTATION OR
 * THE PRODUCTS OR TECHNOLOGIES DESCRIBED THEREIN AT ANY TIME.
 *
 * INFINEON TECHNOLOGIES SHALL NOT BE LIABLE FOR ANY DIRECT, INDIRECT OR
 * CONSEQUENTIAL DAMAGE OR LIABILITY ARISING FROM YOUR USE OF THE SOURCE CODE OR
 * ANY DOCUMENTATION, INCLUDING BUT NOT LIMITED TO, LOST REVENUES, DATA OR
 * PROFITS, DAMAGES OF ANY SPECIAL, INCIDENTAL OR CONSEQUENTIAL NATURE, PUNITIVE
 * DAMAGES, LOSS OF PROPERTY OR LOSS OF PROFITS ARISING OUT OF OR IN CONNECTION
 * WITH THIS AGREEMENT, OR BEING UNUSABLE, EVEN IF ADVISED OF THE POSSIBILITY OR
 * PROBABILITY OF SUCH DAMAGES AND WHETHER A CLAIM FOR SUCH DAMAGE IS BASED UPON
 * WARRANTY, CONTRACT, TORT, NEGLIGENCE OR OTHERWISE.
 *
 * (C)Copyright INFINEON TECHNOLOGIES All rights reserved
 */

package com.infineon.esim.lpa.ui.generic;

@SuppressWarnings("unused")
public class AsyncActionStatus {
    private final ActionStatus actionStatus;
    private Object extras;

    public AsyncActionStatus(ActionStatus actionStatus) {
        this.actionStatus = actionStatus;
    }

    public ActionStatus getActionStatus() {
        return actionStatus;
    }

    public Object getExtras() {
        return extras;
    }

    public void setExtras(Object extras) {
        this.extras = extras;
    }

    public AsyncActionStatus addExtras(Object extras) {
        this.extras = extras;
        return this;
    }

    public boolean isBusy() {
        switch (actionStatus) {
            case GETTING_EUICC_INFO_STARTED:
            case REFRESHING_EUICC_LIST_STARTED:
            case CONNECTING_INTERFACE_STARTED:
            case DISCONNECTING_INTERFACE_STARTED:
            case OPENING_EUICC_CONNECTION_STARTED:
            case GET_PROFILE_LIST_STARTED:
            case ENABLE_PROFILE_STARTED:
            case DISABLE_PROFILE_STARTED:
            case DELETE_PROFILE_STARTED:
            case SET_NICKNAME_STARTED:
            case AUTHENTICATE_DOWNLOAD_STARTED:
            case DOWNLOAD_PROFILE_STARTED:
            case CANCEL_SESSION_STARTED: return true;
            case GETTING_EUICC_INFO_FINISHED:
            case REFRESHING_EUICC_LIST_FINISHED:
            case CONNECTING_INTERFACE_CANCELLED:
            case CONNECTING_INTERFACE_FINISHED:
            case DISCONNECTING_INTERFACE_FINISHED:
            case OPENING_EUICC_CONNECTION_FINISHED:
            case GET_PROFILE_LIST_FINISHED:
            case ENABLE_PROFILE_FINISHED:
            case DISABLE_PROFILE_FINISHED:
            case DELETE_PROFILE_FINISHED:
            case AUTHENTICATE_DOWNLOAD_FINISHED:
            case DOWNLOAD_PROFILE_FINISHED:
            case CANCEL_SESSION_FINISHED:
            case FINISHED_DOWNLOAD_SESSION:
            default: return false;
        }
    }
}
